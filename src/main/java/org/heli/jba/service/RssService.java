package org.heli.jba.service;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

import org.heli.jba.entity.Item;
import org.heli.jba.exception.RssException;
import org.heli.jba.rss.ObjectFactory;
import org.heli.jba.rss.TRss;
import org.heli.jba.rss.TRssChannel;
import org.heli.jba.rss.TRssItem;
import org.springframework.stereotype.Service;

@Service
public class RssService {

	public List<Item> getItems(File file) throws RssException {
		return getItems(new StreamSource(file));
	}

	public List<Item> getItems(String url) throws RssException {
		return  getItems(new StreamSource(url));
	}

	private List<Item> getItems(Source source) throws RssException {

		ArrayList<Item> list = new ArrayList<Item>();
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(ObjectFactory.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			JAXBElement<TRss> jaxbElement = unmarshaller.unmarshal(source,TRss.class);
			TRss rss = jaxbElement.getValue();

			List<TRssChannel> channels = rss.getChannel();
			for (TRssChannel channal : channels) {
				List<TRssItem> items = channal.getItem();
				for (TRssItem rssItem : items) {
					Item item = new Item();
					item.setTitle(rssItem.getTitle());
					item.setDescription(rssItem.getDescription());
					item.setLink(rssItem.getLink());
					Date pubDate = new SimpleDateFormat(
							"EEE,dd MMM yyyy HH:mm:ss Z", Locale.ENGLISH)
							.parse(rssItem.getPubDate());
					item.setPublishedDate(pubDate);
					list.add(item);
				}
			}
		} catch (JAXBException e) {
			throw new RssException(e);
		} catch (ParseException e) {
			throw new RssException(e);
		}
		return list;

	}
}

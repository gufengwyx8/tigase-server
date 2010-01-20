/*
 * Tigase Jabber/XMPP Server
 * Copyright (C) 2004-2008 "Artur Hefczyc" <artur.hefczyc@tigase.org>
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, version 3 of the License.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program. Look for COPYING file in the top folder.
 * If not, see http://www.gnu.org/licenses/.
 * 
 * $Rev$
 * Last modified by $Author$
 * $Date$
 */

package tigase.server;

import tigase.util.TigaseStringprepException;
import tigase.xml.Element;
import tigase.xmpp.JID;
import tigase.xmpp.StanzaType;

/**
 * Created: Dec 31, 2009 8:38:38 PM
 *
 * @author <a href="mailto:artur.hefczyc@tigase.org">Artur Hefczyc</a>
 * @version $Rev$
 */
public class Message extends Packet {

	public static final String ELEM_NAME = "message";

	public Message(Element elem) throws TigaseStringprepException{
		super(elem);
	}

	public Message(Element elem, JID stanzaFrom, JID stanzaTo) {
		super(elem, stanzaFrom, stanzaTo);
	}

	public static Packet getMessage(JID from, JID to, StanzaType type,
		String body, String subject, String thread, String id) {
		Element message = new Element("message",
			new Element[] {new Element("body", body)},
			new String[] {"to", "from", "type"},
			new String[] {to.toString(), from.toString(), type.toString()});
		if (id != null) {
			message.addAttribute("id", id);
		}
		if (subject != null) {
			message.addChild(new Element("subject", subject));
		}
		if (thread != null) {
			message.addChild(new Element("thread", thread));
		}
		return packetInstance(message, from, to);
	}

}
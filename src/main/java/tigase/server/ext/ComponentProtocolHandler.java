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

package tigase.server.ext;

import java.util.List;
import tigase.server.Packet;
import tigase.xml.Element;
import tigase.xmpp.XMPPIOService;

/**
 * Created: Oct 7, 2009 5:54:56 PM
 *
 * @author <a href="mailto:artur.hefczyc@tigase.org">Artur Hefczyc</a>
 * @version $Rev$
 */
public interface ComponentProtocolHandler {

	public static final String REPO_ITEM_KEY = "repo-item";
//	public static final String AUTHENTICATED_KEY = "authenticated";
	public static final String EXTCOMP_BIND_HOSTNAMES_PROP_KEY = "bind-ext-hostnames";

	void authenticated(XMPPIOService<List<ComponentConnection>> serv);

	void bindHostname(String hostname, XMPPIOService<List<ComponentConnection>> serv);

	void unbindHostname(String hostname, XMPPIOService<List<ComponentConnection>> serv);

	CompRepoItem getCompRepoItem(String hostname);

	List<Element> getStreamFeatures(XMPPIOService<List<ComponentConnection>> serv);

	ExtProcessor getProcessor(String string);

	StreamOpenHandler getStreamOpenHandler(String xmlns);

	String newPacketId(String prefix);

	void authenticationFailed(XMPPIOService<List<ComponentConnection>> serv, Packet packet);

}
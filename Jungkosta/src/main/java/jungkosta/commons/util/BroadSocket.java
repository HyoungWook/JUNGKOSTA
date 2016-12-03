package jungkosta.commons.util;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonWriter;
import javax.servlet.http.HttpSession;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.RemoteEndpoint.Basic;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value="/broadsocket", configurator=GetHttpSessionForWebsocket.class)
public class BroadSocket {
    //유저 집합 리스트
    //static List<Session> sessionUsers = Collections.synchronizedList(new ArrayList<>());
    private static String rtnMsg = "";
	static Map<Session, HttpSession> sessions = Collections.synchronizedMap(new HashMap<Session, HttpSession>());
    //웹 소켓이 접속되면 유저리스트에 세션을 넣음.
    //@param userSession 웹소켓 세션    
    
    @OnOpen
    public void handleOpen(Session userSession, EndpointConfig config){
    	System.out.println("세션 ID : " + userSession.getId());
    	
    	HttpSession hss = (HttpSession)config.getUserProperties().get(HttpSession.class.getName());
    	String user = (String)hss.getAttribute("email");
    	System.out.println("Http세션 ID : " + hss.getAttribute("email"));
    	sendAll(userSession, "접속함.", hss, user);
    	//sessionUsers.add(userSession);
    	sessions.put(userSession, hss);
    }
    
    //웹소켓으로부터 메시지가 오면 호출.
    //@param message 메시지
    //@param userSession
    //@throws IOException
    /*@OnMessage
    public void handleMessage(String message, Session userSession)throws IOException{
    	String username = (String)userSession.getUserProperties().get("username");
    	//세션 프로퍼티에 username이 없으면 username을 선언하고 해당 세션으로 메시지를 보냄(json형식)
    	//최초 메세지는 username설정
    	if(username==null){
    		userSession.getUserProperties().put("username", message);
    		userSession.getBasicRemote().sendText(buildJsonData("System", "you are now connected as" + message));
    		return;
    	}
    	
    	//username이 있으면 전체에게 메시지를 보낸다.
    	Iterator<Session> iterator = sessionUsers.iterator();
    	//hash.get("b")
    	while(iterator.hasNext()){
    		iterator.next().getBasicRemote().sendText(buildJsonData(username, message));
    	}
    }*/
    
    @OnMessage
    public void onMessage(String message, Session userSession){
    	System.out.println("세션 ID : " + userSession.getId() + ", 내용: " + message);
    	HttpSession hss = sessions.get(userSession);
    	System.out.println("HTTP세션 ID : " + hss.getAttribute("email"));
    	rtnMsg = rtnMsg + message + "1";
    	System.out.println(rtnMsg);
    	//sendAll(userSession, message, hss);
    	try {
			final Basic basic = userSession.getBasicRemote();
			basic.sendText("YOU[" + hss.getAttribute("email")+"] : " +message);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
    	
    }
    
    public void sendAll(Session ss, String message, HttpSession hss, String user){
    	
    	try {
			for(Entry<Session, HttpSession> entry : BroadSocket.sessions.entrySet()){
				Session ws_ss = entry.getKey();
				HttpSession http_ss = entry.getValue();
				
				if(((String)http_ss.getAttribute("email")).equals(user)){
					ws_ss.getBasicRemote().sendText(user+ "[" + hss.getAttribute("email")+"] : " + message);
					
					System.out.println("sendAll if");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    
    //웹소켓을 닫으면 해당 유저를 유저리스트에서 뺌.
    //@param userSession
    
    @OnClose
    public void handleClose(Session userSession){
    	System.out.println("종료 : " + userSession.getId());
    	sessions.remove(userSession);
    	//sessions.remove(userSession);
    }
    
    @OnError
    public void onError(Throwable t){
    	t.printStackTrace();
    }

	/*private String buildJsonData(String username, String message) {
		JsonObject jsonObject = Json.createObjectBuilder().add("message", username+" : "+ message).build();
		StringWriter stringwriter = new StringWriter();
		
		try(JsonWriter jsonWriter = Json.createWriter(stringwriter)){
			jsonWriter.write(jsonObject);
		};
		
		return stringwriter.toString();
	}*/

}

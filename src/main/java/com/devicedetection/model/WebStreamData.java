package com.devicedetection.model;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft;
import org.java_websocket.handshake.ServerHandshake;

public class WebStreamData extends WebSocketClient
{
    static WebStreamData instance;

	String regex = "\\[\\[.?\\d+";
    List<Integer> data = new ArrayList<Integer>();	

    public static WebStreamData GetInstance()
    {
        try{
            instance = main();

        }
        catch (URISyntaxException e)
        {
            e.printStackTrace();
        }
        return instance;
    }

    public static List<Integer> getWebStreamData()
    {
        return instance.data;
    }

	public WebStreamData( URI serverUri , Draft draft ) {

		super( serverUri, draft );

	}



	public WebStreamData( URI serverURI ) {

		super( serverURI );

	}



/*	public ExampleClient( URI serverUri, Map<String, String> httpHeaders ) {

		super(serverUri, httpHeaders);

	}
*/


	@Override

	public void onOpen( ServerHandshake handshakedata ) {

		send("Hello, it is me. Mario :)");

		System.out.println( "opened connection" );

		// if you plan to refuse connection based on ip or httpfields overload: onWebsocketHandshakeReceivedAsClient

	}



	@Override

	public void onMessage( String message ) {

		System.out.println( "received: " + message );
		Pattern r = Pattern.compile(regex);
		Matcher m = r.matcher(message);
		if(m.find())
		{
			int start = m.start()+2;
			int end = m.end() -1;
			
			String str = message.substring(start, end);
			int val = Integer.parseInt(str);
			System.out.println(val);
			data.add(val);
		}
	}



	@Override

	public void onClose( int code, String reason, boolean remote ) {

		// The codecodes are documented in class org.java_websocket.framing.CloseFrame

		System.out.println( "Connection closed by " + ( remote ? "remote peer" : "us" ) + " Code: " + code + " Reason: " + reason );

	}



	@Override

	public void onError( Exception ex ) {

		ex.printStackTrace();

		// if the error is fatal then onClose will be called additionally

	}



	public static WebStreamData main() throws URISyntaxException {

//		ExampleClient c = new ExampleClient( new URI( "ws://localhost:8000" )); // more about drafts here: http://github.com/TooTallNate/Java-WebSocket/wiki/Drafts
        WebStreamData c = new WebStreamData( new URI( "ws://10.210.0.240:8000" )); // more about drafts here: http://github.com/TooTallNate/Java-WebSocket/wiki/Drafts
		c.setConnectionLostTimeout( 0 );
		c.connect();
        System.out.println("WebSocket Connection started!");
		return c;

	}
}
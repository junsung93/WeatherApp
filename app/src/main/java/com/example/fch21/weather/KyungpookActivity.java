package com.example.fch21.weather;

import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class KyungpookActivity extends Activity {

	TextView textview, temp, reh;
	ImageView img;
	Document doc = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);

		CameraView cameraView = new CameraView(this);
		setContentView(cameraView);

//		addContentView(new MyView(this), new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));

		View v = getLayoutInflater().inflate(R.layout.state, null);
		this.addContentView(v, new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));

		textview = (TextView) findViewById(R.id.textView1);
		temp = (TextView) findViewById(R.id.temperature);
		reh = (TextView) findViewById(R.id.REH);
		img = (ImageView) findViewById(R.id.img);
		GetXMLTask task = new GetXMLTask();
		task.execute("http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=4717034000");
	}

	private class GetXMLTask extends AsyncTask<String, Void, Document> {

		@Override
		protected Document doInBackground(String... urls) {
			URL url;
			try {
				url = new URL(urls[0]);
				DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
				DocumentBuilder db = dbf.newDocumentBuilder(); // XML문서 빌더 객체를
				// 생성
				doc = db.parse(new InputSource(url.openStream())); // XML문서를
				// 파싱한다.
				doc.getDocumentElement().normalize();

			} catch (Exception e) {
				Toast.makeText(getBaseContext(), "Parsing Error", Toast.LENGTH_SHORT).show();
			}
			return doc;
		}

		@Override
		protected void onPostExecute(Document doc) {

			String s = "";
			String sky = "";
			String pty = "";
			int intSky;
			int intPty;

			NodeList nodeList = doc.getElementsByTagName("data");
			int i = 0;

			s += "날씨 정보: ";
			Node node = nodeList.item(i);
			Element fstElmnt = (Element) node;
			NodeList nameList = fstElmnt.getElementsByTagName("temp");
			Element nameElement = (Element) nameList.item(0);
			nameList = nameElement.getChildNodes();
			s += "온도 = " + ((Node) nameList.item(0)).getNodeValue() + ", ";

			NodeList websiteList = fstElmnt.getElementsByTagName("wfKor");

			s += "날씨 = " + websiteList.item(0).getChildNodes().item(0).getNodeValue() + ", ";

			NodeList rehList = fstElmnt.getElementsByTagName("reh");
			s += "습도 = " + rehList.item(0).getChildNodes().item(0).getNodeValue() + "\n";

			NodeList skyList = fstElmnt.getElementsByTagName("sky");
			sky = skyList.item(0).getChildNodes().item(0).getNodeValue();

			NodeList ptyList = fstElmnt.getElementsByTagName("pty");
			pty = ptyList.item(0).getChildNodes().item(0).getNodeValue();

			textview.setText(s);
			temp.setText(((Node) nameList.item(0)).getNodeValue()+"℃");
			reh.setText(rehList.item(0).getChildNodes().item(0).getNodeValue()+"%");


			intSky = Integer.parseInt(sky);
			intPty = Integer.parseInt(pty);

			if((intSky == 1) && (intPty == 0)) {
				img.setImageResource(R.drawable.sun);
			}
			else if ( ((intSky == 2)||(intSky == 3)||(intSky == 4))&&( intPty== 0) ) {
				img.setImageResource(R.drawable.cloud);
			}
			else if (intPty == 1) {
				img.setImageResource(R.drawable.rain);
			}
			else if (intPty == 2) {
				img.setImageResource(R.drawable.snowrain);
			}
			else if (intPty == 3) {
				img.setImageResource(R.drawable.snow);
			}

			super.onPostExecute(doc);
		}

	}
}

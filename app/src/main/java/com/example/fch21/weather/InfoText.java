package com.example.fch21.weather;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

class InfoText {
	public void getInfo(int x, int y) {
		long now = System.currentTimeMillis();
		Date nowDate = new Date();
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		String strDate = dateFormat.format(nowDate);
		
		TimeZone tz;
		tz = TimeZone.getTimeZone("Asia/Seoul");
		SimpleDateFormat timeFormat = new SimpleDateFormat("HHmm");
		timeFormat.setTimeZone(tz);
		String strTime = timeFormat.format(nowDate);
		
		String url = "http://newsky2.kma.go.kr/service/SecndSrtpdFrcstInfoService2/ForecastGrib?";
		String apiKey = "ServiceKey=gGD0lp5yGO76AeBorq8Kqa%2B63ubg4PV5yqv%2B8U0yr%2F%2FPKNYVmxXtx4zUtvQbllC9H%2BOvZwhq%2BwoZ2A27%2FW2i4g%3D%3D";
		String date = "&base_date="+strDate;
		String time = "&base_time="+strTime;
		String loc = "&nx="+x+"&ny="+y;
		String resultCount = "&pageNo=1&numOfRows=10";
		String requestUrl = url+apiKey+date+time+loc+resultCount;
		
		

	}
}

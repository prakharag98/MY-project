package e.t.navigationdrawer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class IANA extends AppCompatActivity {

    WebView webView6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ian);

        webView6=findViewById(R.id.webView6);
        webView6.setWebViewClient(new WebViewClient());
        webView6.getSettings().setJavaScriptEnabled(true);
        webView6.loadUrl("https://www.apnic.net/about-apnic/whois_search/");

    }
    @Override
    public void onBackPressed() {
        if(webView6.canGoBack())
        {
            webView6.goBack();
        }
        else
        {

            Intent intent=new Intent(this,MainActivity.class);
            startActivity(intent);
            IANA.this.finish();

        }
    }
}
package e.t.navigationdrawer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class TrackIp extends AppCompatActivity {

    private WebView webView4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track_ip);

        webView4=findViewById(R.id.webView4);
        webView4.setWebViewClient(new WebViewClient());
        webView4.getSettings().setJavaScriptEnabled(true);
        webView4.getSettings().setBuiltInZoomControls(true);
        webView4.getSettings().setSupportZoom(true);
        webView4.loadUrl("http://iptracker.org");
    }
    @Override
    public void onBackPressed() {
        if(webView4.canGoBack())
        {
            webView4.goBack();
        }
        else
        {

            Intent intent=new Intent(this,MainActivity.class);
            startActivity(intent);
            TrackIp.this.finish();
        }
    }
}

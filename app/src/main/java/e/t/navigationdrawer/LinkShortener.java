package e.t.navigationdrawer;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class LinkShortener extends AppCompatActivity {

    private WebView webView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_link_shortener);

        webView2=findViewById(R.id.webView2);
        webView2.setWebViewClient(new WebViewClient());
        webView2.getSettings().setJavaScriptEnabled(true);
        webView2.loadUrl("https://t2mio.com");
    }
    @Override
    public void onBackPressed() {
        if(webView2.canGoBack())
        {
            webView2.goBack();
        }
        else
            {

                Intent intent=new Intent(this,MainActivity.class);
                startActivity(intent);
                LinkShortener.this.finish();

            }
        }
    }

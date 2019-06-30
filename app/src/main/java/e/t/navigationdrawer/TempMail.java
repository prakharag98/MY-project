package e.t.navigationdrawer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class TempMail extends AppCompatActivity {

    private WebView webView3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp_mail);

        webView3=findViewById(R.id.webView3);
        webView3.setWebViewClient(new WebViewClient());
        webView3.getSettings().setJavaScriptEnabled(true);
        webView3.loadUrl("https://temp-mail.org/en/");
    }
    @Override
    public void onBackPressed() {
        if(webView3.canGoBack())
        {
            webView3.goBack();
        }
        else
        {
            Intent intent=new Intent(this,MainActivity.class);
            startActivity(intent);
            TempMail.this.finish();

        }
    }
}

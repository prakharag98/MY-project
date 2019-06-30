package e.t.navigationdrawer;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class IPLogger extends AppCompatActivity {

    private WebView webView1;
    private FloatingActionButton floatingActionButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iplogger);

        floatingActionButton=findViewById(R.id.floataction);
        webView1=findViewById(R.id.webView1);
        webView1.setWebViewClient(new WebViewClient());
        webView1.getSettings().setJavaScriptEnabled(true);
        webView1.loadUrl("https://grabify.link/");

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(IPLogger.this, "Clicked", Toast.LENGTH_SHORT).show();
                webView1.reload();
            }
        });

    }


    @Override
    public void onBackPressed() {
        if(webView1.canGoBack())
        {
            webView1.goBack();
        }
        else
        {
            Intent intent=new Intent(this,MainActivity.class);
            startActivity(intent);
            IPLogger.this.finish();
        }
    }
}

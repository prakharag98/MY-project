package e.t.navigationdrawer;

import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.format.Formatter;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    TextView textView;
    boolean doubleBackToExitPressedOnce = false;
    private WebView webView;
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=findViewById(R.id.ipShow);
        WifiManager wm = (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);
        String ip = Formatter.formatIpAddress(wm.getConnectionInfo().getIpAddress());
        textView.setText(ip);

        webView=findViewById(R.id.webView5);
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setSupportZoom(true);
        webView.loadUrl("https://www.lifewire.com/what-is-an-ip-address-2625920");

        toolbar =findViewById(R.id.ToolBar1);
        setSupportActionBar(toolbar);

        drawerLayout=findViewById(R.id.drawer_layout);
        navigationView=findViewById(R.id.navigation_view);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId())
                {
                    case R.id.item1:
                        menuItem.setChecked(true);
                        //displayMessage("item 1");
                        Intent intent=new Intent(MainActivity.this,IPLogger.class);
                        startActivity(intent);
                        drawerLayout.closeDrawers();
                        return true;

                    case R.id.item2:
                        menuItem.setChecked(true);
                        //displayMessage("Item 2");
                        Intent intent2=new Intent(MainActivity.this,LinkShortener.class);
                        startActivity(intent2);
                        drawerLayout.closeDrawers();
                        return true;

                    case R.id.item3:
                        menuItem.setChecked(true);
                        //displayMessage("Item 2");
                        Intent intent3=new Intent(MainActivity.this,TempMail.class);
                        startActivity(intent3);
                        drawerLayout.closeDrawers();
                        return true;

                    case R.id.item4:
                        menuItem.setChecked(true);
                        //displayMessage("Item 2");
                        Intent intent4=new Intent(MainActivity.this,TrackIp.class);
                        startActivity(intent4);
                        drawerLayout.closeDrawers();
                        return true;

                    case R.id.item5:
                        menuItem.setChecked(true);
                        //displayMessage("Item 2");
                        Intent intent5=new Intent(MainActivity.this,CheckIp.class);
                        startActivity(intent5);
                        drawerLayout.closeDrawers();
                        return true;

                    case R.id.item6:
                        menuItem.setChecked(true);
                        //displayMessage("Item 2");
                        Intent intent6=new Intent(MainActivity.this,IANA.class);
                        startActivity(intent6);
                        drawerLayout.closeDrawers();
                        return true;
                }
                return false;
            }
        });
    }
    @Override
    public void onBackPressed() {

        if(webView.canGoBack())
        {
            webView.goBack();
        }
        else
        {
            if (doubleBackToExitPressedOnce) {
                super.onBackPressed();
                return;
            }

            this.doubleBackToExitPressedOnce = true;
            Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                    doubleBackToExitPressedOnce=false;
                }
            }, 2000);
        }
    }

    private void displayMessage(String message)
    {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}

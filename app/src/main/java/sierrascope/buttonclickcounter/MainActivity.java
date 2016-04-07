package sierrascope.buttonclickcounter;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // variables
    private Button ourButton;
    private TextView ourMessage;
    private int numTimesClicked =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // these link the variables in the Java code to the view in the XML layouts
        ourButton = (Button) findViewById(R.id.button);
        ourMessage = (TextView) findViewById(R.id.textview);
        // onClickListener that changes the textView when ourButton is clicked
        View.OnClickListener ourOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numTimesClicked = numTimesClicked + 1;
//                String total = Integer.toString(numTimesClicked);
                String result = "The button got tapped " + numTimesClicked + " time";
                if (numTimesClicked != 1) {
                    result += "s";
                }
                    ourMessage.setText(result);
                }
        };

        // this tells the button (variable) that we defined to use the code associated with the onClickListener
        ourButton.setOnClickListener(ourOnClickListener);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Toast toastMessage = Toast.makeText(this, "The counter has been reset", Toast.LENGTH_LONG);
            toastMessage.show();
            // this resets the counter to 0. A single = sign assigns value double == checks value
            numTimesClicked = 0;
            ourMessage.setText("Hello World!!");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

package aalto.eero.mymind.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import aalto.eero.mymind.R;

public class MainActivity extends BaseActivity {
    private Toolbar toolbar;
    private Button scienceButton;
    private Intent nextIntent;
    private String CHANNEL = "CHANNEl";

    @Override
    protected void onCreate(Bundle savedState) {
        super.onCreate(savedState);

        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.main_app_bar);
        setSupportActionBar(toolbar);

        scienceButton = (Button) findViewById(R.id.main_science_button);
        nextIntent = new Intent(this, ChannelActivity.class);

        scienceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextIntent.putExtra(CHANNEL, "Science");
                startActivity(nextIntent);


            }
        });


    }




}

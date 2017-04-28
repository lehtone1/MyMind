package aalto.eero.mymind.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import aalto.eero.mymind.R;

public class MainActivity extends BaseActivity {
    private Toolbar toolbar;
    private LinearLayout scienceButton;
    private Intent nextIntent;
    private String CHANNEL = "CHANNEl";

    @Override
    protected void onCreate(Bundle savedState) {
        super.onCreate(savedState);

        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.main_app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        scienceButton = (LinearLayout) findViewById(R.id.main_science_button);
        nextIntent = new Intent(this, ChannelActivity.class);

        scienceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextIntent.putExtra(CHANNEL, "Science");
                startActivity(nextIntent);


            }
        });


    }

    private String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getAssets().open("channelsAndContent.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }



    private void getChannelsFromJson() {
        try {
            JSONObject obj = new JSONObject(loadJSONFromAsset());
            Iterator<String> iterator = obj.keys();
            //ArrayAdapter<String> adapter;
            List<String> list;

            LayoutInflater inflater = (LayoutInflater) this.getSystemService
                    (Context.LAYOUT_INFLATER_SERVICE);

            int number = 0;

            list = new ArrayList<String>();
            while (iterator.hasNext()) {
                number ++;
                //list.add(iterator.next());
                /*
                articlePreview = (RelativeLayout) inflater.inflate(R.layout.article_preview, null);
                channelNewsLayout.addView(articlePreview);
                TextView channel = (TextView) articlePreview.findViewById(R.id.preview_channel);
                channel.setText(iterator.next());
                 */

            }

/*
            adapter = new ArrayAdapter<String>(
                    this.getActivity(), android.R.layout.simple_spinner_item, list);

            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            registerCountrySpin.setAdapter(adapter);
*/

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }




}

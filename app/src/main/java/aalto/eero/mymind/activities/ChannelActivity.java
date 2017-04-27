package aalto.eero.mymind.activities;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import aalto.eero.mymind.R;

/**
 * Created by lehtone1 on 24/04/17.
 */

public class ChannelActivity extends BaseActivity implements View.OnClickListener {
    private Toolbar toolbar;
    private LinearLayout channelNewsLayout;
    private RelativeLayout articlePreview;

    @Override
    protected void onCreate(Bundle savedState) {
        super.onCreate(savedState);

        setContentView(R.layout.acitivity_channel);

        toolbar = (Toolbar) findViewById(R.id.main_app_bar);
        setSupportActionBar(toolbar);
        getChannelsFromJson();

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

            JSONArray jsonArray;
            List<String> list;
            channelNewsLayout = (LinearLayout) findViewById(R.id.channel_news);

            jsonArray = obj.getJSONObject("Science").getJSONArray("articles");

            LayoutInflater inflater = (LayoutInflater) this.getSystemService
                    (Context.LAYOUT_INFLATER_SERVICE);

            list = new ArrayList<String>();
            //System.out.println(jsonArray.length());
            for(int i = 0; i < jsonArray.length(); i ++) {
                //list.add(iterator.next());
                articlePreview = (RelativeLayout) inflater.inflate(R.layout.article_preview, null);
                channelNewsLayout.addView(articlePreview);

                TextView channel = (TextView) articlePreview.findViewById(R.id.preview_source);
                channel.setText(jsonArray.getJSONObject(i).getString("source"));

                TextView header = (TextView) articlePreview.findViewById(R.id.preview_header);
                header.setText(jsonArray.getJSONObject(i).getString("header"));

                TextView time = (TextView) articlePreview.findViewById(R.id.preview_time);
                time.setText(jsonArray.getJSONObject(i).getString("time"));

                articlePreview.setOnClickListener(this);


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


    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, ArticleActivity.class);
        startActivity(intent);


    }
}

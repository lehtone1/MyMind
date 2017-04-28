package aalto.eero.mymind.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

import aalto.eero.mymind.R;

/**
 * Created by lehtone1 on 24/04/17.
 */

public class ArticleActivity extends BaseActivity implements View.OnClickListener {
    private TextView header;
    private TextView source;
    private TextView time;
    private TextView chapter;
    private TextView channel;
    private TextView toolbarChannelName;
    private int id;
    private LinearLayout textContainer;
    private Toolbar toolbar;
    private ImageView toolbarImageX;
    private Intent previousIntent;



    @Override
    protected void onCreate(Bundle savedState) {
        super.onCreate(savedState);

        setContentView(R.layout.activity_article);

        header = (TextView) findViewById(R.id.article_header);
        source = (TextView) findViewById(R.id.article_source_text);
        time = (TextView) findViewById(R.id.article_time_text);
        textContainer = (LinearLayout) findViewById(R.id.article_text_container);
        channel = (TextView) findViewById(R.id.article_channel_name);
        toolbar = (Toolbar) findViewById(R.id.top_bar_article);
        toolbarImageX = (ImageView) toolbar.findViewById(R.id.top_bar_article_image_x);
        toolbarChannelName = (TextView) toolbar.findViewById(R.id.top_bar_article_channel_name);
        previousIntent = new Intent(this, ChannelActivity.class);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        toolbarImageX.setOnClickListener(this);

        Bundle extra = getIntent().getExtras();
        if(extra != null) {
            id = extra.getInt("ID");
        }

        getArticleFromJson();
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

    private void getArticleFromJson() {
        try {
            JSONObject obj = new JSONObject(loadJSONFromAsset());

            JSONArray jsonArray;
            textContainer = (LinearLayout) findViewById(R.id.article_text_container);

            jsonArray = obj.getJSONObject("Science").getJSONArray("articles");

            LayoutInflater inflater = (LayoutInflater) this.getSystemService
                    (Context.LAYOUT_INFLATER_SERVICE);

            for(int i = 0; i < jsonArray.length(); i ++) {

                System.out.println(jsonArray.getJSONObject(i).getInt("id"));
                if(jsonArray.getJSONObject(i).getInt("id") == id) {
                    source.setText(jsonArray.getJSONObject(i).getString("source"));
                    header.setText(jsonArray.getJSONObject(i).getString("header"));
                    time.setText(jsonArray.getJSONObject(i).getString("time"));
                    channel.setText("Science");
                    toolbarChannelName.setText("SCIENCE CHANNEL");

                    JSONArray text = jsonArray.getJSONObject(i).getJSONArray("text");

                    for(int position = 0; position < text.length(); position++) {
                        if(position % 2 == 0 ) {
                            chapter = (TextView) inflater.inflate(R.layout.article_text, null);
                            chapter.setText(text.getString(position));
                            textContainer.addView(chapter);

                        } else {
                            chapter = (TextView) inflater.inflate(R.layout.article_sub_header, null);
                            chapter.setText(text.getString(position));
                            textContainer.addView(chapter);

                        }
                    }





                }



            }


        } catch (JSONException e) {
            e.printStackTrace();
        }

    }


    @Override
    public void onClick(View v) {
        previousIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(previousIntent);
        finish();

    }
}


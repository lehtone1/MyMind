package aalto.eero.mymind.activities;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import aalto.eero.mymind.R;

/**
 * Created by lehtone1 on 24/04/17.
 */

public class ChannelActivity extends BaseActivity {
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedState) {
        super.onCreate(savedState);

        setContentView(R.layout.acitivity_channel);

        toolbar = (Toolbar) findViewById(R.id.main_app_bar);
        setSupportActionBar(toolbar);
    }
}

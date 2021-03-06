package aalto.eero.mymind.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import aalto.eero.mymind.infrastructure.MyMindApplication;

/**
 * Created by lehtone1 on 24/04/17.
 */

public class BaseActivity extends AppCompatActivity {
    protected MyMindApplication application;

    @Override
    protected void onCreate(Bundle savedState) {
        super.onCreate(savedState);

        application = (MyMindApplication) getApplication();
    }

}

package aalto.eero.mymind.fragments;

import android.app.Fragment;
import android.os.Bundle;

import aalto.eero.mymind.infrastructure.MyMindApplication;

/**
 * Created by lehtone1 on 24/04/17.
 */

public class BaseFragment extends android.support.v4.app.Fragment {
    protected MyMindApplication application;

    @Override
    public void onCreate(Bundle savedState) {
        super.onCreate(savedState);

        application = (MyMindApplication) getActivity().getApplication();
    }

}

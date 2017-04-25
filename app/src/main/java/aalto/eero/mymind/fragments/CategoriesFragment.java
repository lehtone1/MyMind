package aalto.eero.mymind.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import aalto.eero.mymind.R;

/**
 * Created by lehtone1 on 24/04/17.
 */

public class CategoriesFragment extends BaseFragment{

    public static CategoriesFragment newInstance() {
        Bundle arguments = new Bundle();
        CategoriesFragment fragment = new CategoriesFragment();
        fragment.setArguments(arguments);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup root, Bundle savedState) {
        View view = inflater.inflate(R.layout.content_categories, root, false);

        return view;


    }
}

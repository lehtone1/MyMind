package aalto.eero.mymind.activities;

import android.os.Bundle;

import aalto.eero.mymind.R;
import aalto.eero.mymind.fragments.CategoriesFragment;


/**
 * Created by lehtone1 on 24/04/17.
 */

public class CategoriesActivity extends BaseActivity {
    CategoriesFragment categoriesFragment;


    @Override
    public void onCreate(Bundle savedState) {
        super.onCreate(savedState);

        setContentView(R.layout.activity_categories);

        categoriesFragment = (CategoriesFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);

        if (categoriesFragment == null) {
            categoriesFragment = CategoriesFragment.newInstance();

            addFragmentToActivity(getSupportFragmentManager(),
                    categoriesFragment, R.id.contentFrame);
        }
    }



}

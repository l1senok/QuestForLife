package mmcompany.questforlife;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

/**
 * Created by alice on 01.06.16.
 */
public abstract class SingleFragmentActivity extends FragmentActivity {

    protected abstract Fragment createFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quest);

        //получаем fm для управления объектами списком и стеком транзакцй фрагментов
        FragmentManager fm = getSupportFragmentManager();
        //support используется толлько потому, что используется библиотека поддержки и класс,иначе нужно субклассировать Activity и вызывать getFM()
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);//при повороте экрана восстанавливает уже существующий фрагмент

        if (fragment == null) {
            fragment = createFragment();
            fm.beginTransaction().add(R.id.fragment_container, fragment).commit();
        }

    }
}

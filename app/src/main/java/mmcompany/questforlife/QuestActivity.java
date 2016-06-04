package mmcompany.questforlife;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import java.util.UUID;

/**
 * Created by alice on 04.06.16.
 * хост для QuestFragment
 * Активность для отображение 1 квеста(создание, само описание в фрагменте(QuestFragment))
 */
public class QuestActivity extends SingleFragmentActivity {

    private static final String EXTRA_QUEST_ID = "mmcompany.questforlife.android.criminalintent.crime_id";


    @Override
    protected Fragment createFragment(){
        UUID questId = (UUID) getIntent().getSerializableExtra(EXTRA_QUEST_ID);
        return QuestFragment.newInstance(questId);
    }

    public static Intent newIntent(Context packageContext, UUID questId){
        Intent intent = new Intent(packageContext, QuestActivity.class);
        intent.putExtra(EXTRA_QUEST_ID, questId);
        return intent;
    }
}


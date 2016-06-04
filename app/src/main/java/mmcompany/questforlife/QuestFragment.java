package mmcompany.questforlife;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.UUID;

/**
 * Created by alice on 04.06.16.
 */
public class QuestFragment extends Fragment {

    private static final String ARG_QUEST_ID = "quest_id";

    private Quest mQuest;
    private ImageView mQuestImage;
    private TextView mQuestTitle;
    private TextView mQuestType;
    private CheckBox mQuestComlete;
    private TextView mQuestProgress;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UUID questId = (UUID) getArguments().getSerializable(ARG_QUEST_ID);
        mQuest = QuestC.get(getActivity()).getQuest(questId);
    }


    public static QuestFragment newInstance(UUID questId) {
        //создает пакет аргументов, создает экземпляр фрагмента, после присоединяет аргументы к фрагменту
        Bundle args = new Bundle();
        args.putSerializable(ARG_QUEST_ID, questId);

        QuestFragment fragment = new QuestFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        //заполняется макет представления фрагмента, заполненный объект view возвращается
        View v = inflater.inflate(R.layout.fragment_quest, container, false);

        mQuestImage = (ImageView)v.findViewById(R.id.quest_type_image);
        mQuestImage.setImageResource(R.drawable.one);
        mQuestTitle = (TextView)v.findViewById(R.id.quest_name);
        mQuestTitle.setText(mQuest.getNameQuest());
        mQuestType = (TextView)v.findViewById(R.id.quest_type_text);
        mQuestType.setText(mQuest.getTypeQuestText());
        mQuestProgress = (TextView)v.findViewById(R.id.quest_progress);
        mQuestProgress.setText(mQuest.getProgressQuest() + "");


        //Можно менять вьюшку
        mQuestComlete = (CheckBox) v.findViewById(R.id.quest_checkbox);
        //слушатель на CheckBox
        mQuestComlete.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //назначение флага выполнения квеста
                 mQuest.setComplete(isChecked);
                }
        });

    return v;
    }


}
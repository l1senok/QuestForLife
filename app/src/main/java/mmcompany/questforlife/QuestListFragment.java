package mmcompany.questforlife;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by alice on 04.06.16.
 */
public class QuestListFragment extends Fragment {
    //ViewHolder и Adapter прописан здес

    private RecyclerView mQuestRecyclerView;
    private QuestAdapter mAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_quest_list, container, false);

        mQuestRecyclerView = (RecyclerView) view.findViewById(R.id.quest_recycler_view);
        //LayoutManager - необходим RV
        mQuestRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();//настройка пользовательского интерфейса

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        //для сохранения изменений
        updateUI();
    }

    private void updateUI(){
        QuestC questC = QuestC.get(getActivity());
        List<Quest> quests = questC.getQuests();
        if (mAdapter == null) {
            mAdapter = new QuestAdapter(quests);
            mQuestRecyclerView.setAdapter(mAdapter);
        }else {
            //для сохранения изменений
            mAdapter.notifyDataSetChanged();
        }


    }

    //ViewHolder
    private  class QuestHolder extends RecyclerView.ViewHolder
    implements View.OnClickListener{
        //Хранит ссылку на одно представление, ожидается что itemView относится к типу TextView
        private Quest mQuest;

        //Поля вьюшек которыми заполняется RV
        private ImageView mQuestImageView;
        private TextView mQuestTitleView;
        private TextView mQuestTypeView;
        private TextView mQuestProgressView;
        private CheckBox mQuestComleteView;

        public QuestHolder(View itemview){
            super(itemview);
            itemview.setOnClickListener(this);

            mQuestImageView = (ImageView) itemview.findViewById(R.id.quest_item_type_image);
            mQuestTitleView = (TextView) itemview.findViewById(R.id.quest_item_name);
            mQuestTypeView = (TextView) itemview.findViewById(R.id.quest_item_type_text);
            mQuestComleteView = (CheckBox) itemview.findViewById(R.id.quest_item_checkbox);
            mQuestProgressView = (TextView) itemview.findViewById(R.id.quest_item_progress);

        }

        public void bindQuest(Quest quest){
            mQuest = quest;
            mQuestImageView.setImageResource(R.drawable.one);
            mQuestTitleView.setText(quest.getNameQuest());
            mQuestTypeView.setText(quest.getTypeQuestText());
            mQuestProgressView.setText("Прогресс: " + quest.getProgressQuest() + "%");
            mQuestComleteView.setChecked(quest.isComplete());
        }

        @Override
        public void onClick(View v) {
            Intent intent = QuestActivity.newIntent(getActivity(), mQuest.getId());
            startActivity(intent);
        }
    }

    //Adapter
    private class QuestAdapter extends  RecyclerView.Adapter<QuestHolder> {

        private List<Quest> mQuests;

        public QuestAdapter(List<Quest> quests) {
            mQuests = quests;
        }

        @Override
        public QuestHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            //вызывается,когда требуется новое представление для отображения элемента
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater.inflate(R.layout.quest_list_item, parent, false);

            return new QuestHolder(view);
        }

        @Override
        public void onBindViewHolder(QuestHolder holder, int position) {
            //связываем представление view обекта VH с объектом модели
            Quest quest = mQuests.get(position);
            holder.bindQuest(quest);
        }

        @Override
        public int getItemCount() {
            return mQuests.size();
        }
    }
}

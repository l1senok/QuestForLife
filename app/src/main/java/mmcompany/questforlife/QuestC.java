package mmcompany.questforlife;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by alice on 04.06.16.
 */
public class QuestC {

    private static QuestC sQuestC;

    private List<Quest> mQuests;

    //закрытый конструктор
    private QuestC(Context context) {
        //генерирование списка из десяти элементов, где каждое второй квест имеет метку "не раскрыто"
        mQuests = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Quest quest = new Quest();
            quest.setNameQuest("Quest №" + i);
            quest.setComplete(i % 2 == 0);
            mQuests.add(quest);
        }
    }

    public  static QuestC get(Context context){
        //либо возвращает уже готовый, либо задает новый обект класса
        if (sQuestC == null){
            sQuestC = new QuestC(context);
        }
        return sQuestC;
    }

    //get-метод для списка
    public List<Quest> getQuests() {
        return mQuests;
    }

    //get-метод для элемента списка
    public Quest getQuest(UUID id) {
        for (Quest quest : mQuests) {
            if (quest.getId().equals(id)) {
                return quest;
            }
        }
        return null;
    }
}


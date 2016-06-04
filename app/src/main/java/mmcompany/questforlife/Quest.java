package mmcompany.questforlife;

import java.util.UUID;

/**
 * Created by alice on 04.06.16.
 * @author alice
 * @since 04.06.16
 * @version 1
 *
 */
public class Quest {

    private UUID mId;//уникальный идентификатор для объекта
    private int mTypeImage;//Картинка типа квеста(спорт, учеба и т.д)
    private String mName;//Название квеста
    private String  mTypeText;//Тип квеста
    private int mProgress;//Прогресс выполнения
    private boolean mComplete;//сатус выполнен или нет

    public Quest(){
        //int tqi, String nq, String tqt
        mId = UUID.randomUUID();
    }

    public UUID getId() {
        return mId;
    }

    public int getTypeQuestImage() {
        return mTypeImage;
    }

    public String getNameQuest() {
        return mName;
    }

    public String getTypeQuestText() {
        return mTypeText;
    }

    public int getProgressQuest() {
        return mProgress;
    }

    public boolean isComplete() {
        return mComplete;
    }

    public void setTypeQuestImage(int typeImage) {
        mTypeImage = typeImage;
    }

    public void setNameQuest(String name) {
        mName = name;
    }

    public void setTypeQuestText(String typeText) {
        mTypeText = typeText;
    }

    public void setProgressQuest(int progress) {
        mProgress = progress;
    }

    public void setComplete(boolean complete) {
        mComplete = complete;
    }

}

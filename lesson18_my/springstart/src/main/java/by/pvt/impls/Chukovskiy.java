package by.pvt.impls;

import by.pvt.i_face.Lyricist;

public class Chukovskiy implements Lyricist {
    @Override
    public String generate() {
        return "У меня зазвонил телефон.\n" +
                "- Кто говорит?\n" +
                "- Слон.\n" +
                "- Откуда?\n" +
                "- От верблюда.\n" +
                "- Что вам надо?\n" +
                "- Шоколада.\n" +
                "- Для кого?\n" +
                "- Для сына моего.\n" +
                "- А много ли прислать?\n" +
                "- Да пудов этак пять\n" +
                "Или шесть:\n" +
                "Больше ему не съесть,\n" +
                "Он у меня еще маленький!\n";
    }
}

package by.pvt.impls;

import by.pvt.i_face.Lyricist;

public class Pushkin implements Lyricist {
    @Override
    public String generate() {
        return "Я помню чудное мгновенье:\r\n"
                + "Передо мной явилась ты,\r\n"
                + "Как мимолетное виденье,\r\n"
                + "Как гений чистой красоты.";
    }
}

package com.swarawan.doraemon.data;

import com.swarawan.doraemon.model.Character;
import com.swarawan.doraemon.model.Skill;
import com.swarawan.doraemon.model.Stun;

import java.util.ArrayList;
import java.util.List;

public class GameData {

    public List<Character> allCharacters() {
        Character doraemon = new Character();
        doraemon.setName("Doraemon");
        doraemon.setHp(1000);
        doraemon.setMana(500);
        doraemon.setSkills(doraemonSkills());

        Character nobita = new Character();
        nobita.setName("Nobita Nobi");
        nobita.setHp(900);
        nobita.setMana(700);
        nobita.setSkills(nobitaSkills());

        Character giant = new Character();
        giant.setName("Takeshi Goda");
        giant.setHp(1200);
        giant.setMana(400);
        giant.setSkills(giantSkills());

        List<Character> characters = new ArrayList<>();
        characters.add(doraemon);
        characters.add(nobita);
        characters.add(giant);

        return characters;
    }

    private List<Skill> doraemonSkills() {
        Skill senterPengecil = new Skill();
        senterPengecil.setName("Senter Pengecil");
        senterPengecil.setDesc("Mengecilkan musuh dan menginjaknya.");
        senterPengecil.setDamage(30);
        senterPengecil.setManaConsume(25);
        senterPengecil.setStun(new Stun(0, 0));

        Skill sarungTanganSuper = new Skill();
        sarungTanganSuper.setName("Sarung Tangan Super");
        sarungTanganSuper.setDesc("Memukul musuh dengan kekuatan 100 orang dewasa");
        sarungTanganSuper.setDamage(50);
        sarungTanganSuper.setManaConsume(60);
        sarungTanganSuper.setStun(new Stun(40, 1));

        Skill meriamAngin = new Skill();
        meriamAngin.setName("Meriam Angin");
        meriamAngin.setDesc("Menembakkan meriam angin untuk memukul mundur musuh");
        meriamAngin.setDamage(25);
        meriamAngin.setManaConsume(10);
        meriamAngin.setStun(new Stun(10, 1));

        Skill selimutWaktu = new Skill();
        selimutWaktu.setName("Selimut Waktu");
        selimutWaktu.setDesc("Mengembalikan musuh kembali ke umur 5 tahun selama beberapa saat.");
        selimutWaktu.setDamage(25);
        selimutWaktu.setManaConsume(100);
        selimutWaktu.setStun(new Stun(100, 2));


        List<Skill> skills = new ArrayList<>();
        skills.add(senterPengecil);
        skills.add(sarungTanganSuper);
        skills.add(meriamAngin);
        skills.add(selimutWaktu);

        return skills;
    }

    private List<Skill> nobitaSkills() {
        Skill lemparBatu = new Skill();
        lemparBatu.setName("Lempar Batu");
        lemparBatu.setDesc("Nobita melempari musuh dengan batu kecil");
        lemparBatu.setDamage(40);
        lemparBatu.setManaConsume(25);
        lemparBatu.setStun(new Stun(20, 1));

        Skill rotiMemory = new Skill();
        rotiMemory.setName("Roti Penerjemah");
        rotiMemory.setDesc("Demi mendapatkan nilai baik ketika ujian, nobita meng-copy semua pelajaran menjadi roti. Dan mengejek musuh sehingga sakit hati");
        rotiMemory.setDamage(50);
        rotiMemory.setManaConsume(50);
        rotiMemory.setStun(new Stun(0, 0));

        Skill meriamAngin = new Skill();
        meriamAngin.setName("Meriam Angin");
        meriamAngin.setDesc("Menembakkan meriam angin untuk memukul mundur musuh");
        meriamAngin.setDamage(25);
        meriamAngin.setManaConsume(10);
        meriamAngin.setStun(new Stun(10, 1));

        Skill kueMomotaro = new Skill();
        kueMomotaro.setName("Kue Momotaro");
        kueMomotaro.setDesc("Nobita memanggil dinosaurus untuk membantu mengalahkan musuh");
        kueMomotaro.setDamage(100);
        kueMomotaro.setManaConsume(150);
        kueMomotaro.setStun(new Stun(0, 0));


        List<Skill> skills = new ArrayList<>();
        skills.add(lemparBatu);
        skills.add(rotiMemory);
        skills.add(meriamAngin);
        skills.add(kueMomotaro);

        return skills;
    }

    private List<Skill> giantSkills() {
        Skill lemparBatu = new Skill();
        lemparBatu.setName("Pukulan Giant");
        lemparBatu.setDesc("Giant memukul sekuat tenaga");
        lemparBatu.setDamage(60);
        lemparBatu.setManaConsume(80);
        lemparBatu.setStun(new Stun(0, 0));

        Skill rotiMemory = new Skill();
        rotiMemory.setName("Lemparan Bola Kasti");
        rotiMemory.setDesc("Lemparan maut Giant");
        rotiMemory.setDamage(50);
        rotiMemory.setManaConsume(90);
        rotiMemory.setStun(new Stun(25, 1));

        Skill meriamAngin = new Skill();
        meriamAngin.setName("Meriam Angin");
        meriamAngin.setDesc("Menembakkan meriam angin untuk memukul mundur musuh");
        meriamAngin.setDamage(25);
        meriamAngin.setManaConsume(10);
        meriamAngin.setStun(new Stun(0, 0));

        Skill menyanyi = new Skill();
        menyanyi.setName("Aku adalah Giant....!!");
        menyanyi.setDesc("Giant menyanyi dengan gagahnya, dapat menyebabkan musuh pusing beberapa saat");
        menyanyi.setDamage(150);
        menyanyi.setManaConsume(200);
        menyanyi.setStun(new Stun(50, 1));


        List<Skill> skills = new ArrayList<>();
        skills.add(lemparBatu);
        skills.add(rotiMemory);
        skills.add(meriamAngin);
        skills.add(menyanyi);

        return skills;
    }
}

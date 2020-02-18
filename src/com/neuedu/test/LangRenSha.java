package com.neuedu.test;

import java.util.*;

/**
 * Created by Daniel on 2020/2/13.
 */
public class LangRenSha {
    public static void main(String[] args) {
        /**
         * 狼人杀发牌器
         * 人数在12~18人之内
         *
         * */
        Scanner scanner = new Scanner(System.in);
        //接受发牌人数
        int player = scanner.nextInt();
        if (player>18||player<12){
            System.out.println("游戏人数不符合");
        }else{


            /**
             *
             * 游戏人数符合开始发牌
             *
             * 定义3个list
             * 1 发牌的列表
             * 2 发到的牌的列表
             * 3 底牌列表
             *
             * */
            List<String> all = new ArrayList<>();
            List<String> play = new ArrayList<>();
            List<String> di = new ArrayList<>();
            init(all);
            pai(all,player);
            //盗贼一定在牌局中，移除总牌中的盗贼
            all.remove("盗贼");
            play.add("盗贼");
            dipai(all,di);
            //将放完底牌的牌数 全部放入游戏牌中
            play.addAll(all);
            //将牌打乱顺序
            Collections.shuffle(play);
            System.out.println("手牌："+play);
            System.out.println("底牌："+di);

        }
    }
    public static void init(List<String> list){
        //循环增加狼人个数
        for (int i=0;i<4;i++){
            list.add("狼人");
        }
        //循环增加村民个数
        for (int i=0;i<4;i++) {
            list.add("村民");
        }
        list.add("女巫");
        list.add("预言家");
        list.add("丘比特");
        list.add("守护");
        list.add("猎人");
        list.add("村长");
        list.add("盗贼");
    }
    public static void pai(List<String> list,int player){
        if (player>12)
            list.add("村民");
        if (player>13)
            list.add("替罪羊");
        if (player>14)
            list.add("狼人");
        if (player>15)
            list.add("村民");
        if (player>16)
            list.add("村民");
        if (player>17)
            list.add("吹笛者");
    }

    //从总牌中拿出三张底牌
    public static void dipai(List<String> list,List<String> di){
        //狼人数小于等于1
        while (di.size()<3){
            //取list的一个随机下标
            Random random = new Random();
            int index = random.nextInt(list.size());
            if (di.contains("狼人")&&list.get(index).equals("狼人")){
                continue;
            }else{
                di.add(list.remove(index));
            }
        }
    }
}

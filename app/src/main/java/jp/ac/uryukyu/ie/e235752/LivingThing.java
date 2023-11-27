package jp.ac.uryukyu.ie.e235752;

public class LivingThing {
    private String name;
    private int hitPoint;
    private int attack;
    private boolean dead;

    LivingThing(String name, int maximumHP, int attack){
        this.name = name;
        hitPoint = maximumHP;
        this.attack = attack;
        dead = false;
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", name, maximumHP, attack);
    }

    /** 生死状態のセッター*/
    public void setDead(boolean dead){
        this.dead = dead;
    }
    /** 生死状態のゲッター
     * @return 生死状態
    */
    public boolean isDead(){
        return dead;
    }
    /** 名前のゲッター
     * @return 名前
    */
    public String getName(){
        return name;
    }
    /** 攻撃力のゲッター
     * @return 攻撃力
    */
    public int getAttack(){
        return attack;
    }

    /** HPのゲッター
     * @return HP
    */
    public int getHitPoint(){
        return hitPoint;
    }

    /**
     * 対戦相手へ攻撃するメソッド。
     * attackに応じて乱数でダメージを算出し、wounded()によりダメージ処理を実行。
     * @param opponent 攻撃対象
     */
    public void attack(LivingThing opponent){
        if(dead == false){
            int damage = (int)(Math.random() * attack);
            System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", name, opponent.getName(), damage);
            opponent.wounded(damage);    
        }
    }

    public void attackWithWeponSkill(LivingThing opponent){
        if(dead == false){
            int damage = (int)(attack * 3/2);
            System.out.printf("%sの攻撃！ウェポンスキルを発動！%sに%dのダメージを与えた！！\n", name, opponent.getName(), damage);
            opponent.wounded(damage);    
        }
    }
    /**
     * 自身へ攻撃されたときのダメージ処理をするメソッド。
     * 指定されたダメージを hitPoint から引き、死亡判定を行う。
     * @param damage 受けたダメージ
     */
    public void wounded(int damage){
        hitPoint -= damage;
        if( hitPoint < 0 ) {
            dead = true;
            System.out.printf("%sは倒れた。\n", name);
        }
    }
}

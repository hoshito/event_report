# 情報
- 【東京】【初学者向け】JJUG ナイトセミナ 「Javaのプログラムはどうやって動いているの?」
- 日時: 2015/04/24 19:00-21:00
- 会場: 日本オラクル株式会社
- 講師: 櫻庭 祐一
  - Web: http://www.javainthebox.com/
  - 連載中: [java技術最前線](http://itpro.nikkeibp.co.jp/article/COLUMN/20060915/248243/)

# 概要
## 前半（JVM編）
- JVMは実行時コンパイル（Just-in-Time Compile）
- Java -> classファイル -> バイトコード
  - バイトコードはjavapで確認可能
- 5つの手順: JVM起動, クラスロード, リンク, 初期化, main実行
  - JVM起動: JNI_CreateJavaVM()
  - クラスロード: 芋づる式に読み込む. "java verbose:class クラス名"で確認可能.
  - staticフィールドの初期化, Javaコードの実行タイミングが異なるのは注意
- JVM: Stack Machine
  - スレッドの中でフレームのスタック, フレームのスタックの中でJavaStack
  - スタックがあふれるとStackOverFlow

## 後半（GC編）
- 世代別GC（Mark&Sweep + Copyのいいとこどり）
  - Mark&Sweep
    - 利点: 実装がシンプル. 参照の書き換えがないため, 安全.
    - 欠点: stop-the-worldの時間が長い. ヒープの断片化が起きやすい. 
  - Copy
    - 利点: stop-the-worldの時間が短い. ヒープの断片化が起きない. 高速なアロケーション
    - 欠点: ヒープの使用効率が悪い. 参照書き換えがある. 

- 原理を知って, チューニングに活かす
  - Old世代のGCをなるべく減らす

# 書籍
- [Java仮想マシン仕様 (The Java series)](http://www.amazon.co.jp/dp/489471356X)
- [ガベージコレクションのアルゴリズムと実装](http://www.amazon.co.jp/dp/4798025623)

# 資料
### 前半（JVM編）
- http://www.slideshare.net/skrb/java-jvm
- https://www.youtube.com/watch?v=QNJBcrSayME

### 後半（GC編）
- http://www.slideshare.net/skrb/java-gc-47402594
- https://www.youtube.com/watch?v=XFsvk5vztn4

# メモ
## 前半（JVM編）
### はじめに
- Classファイルからmainメソッドを実行するまでを紹介
- このスライド（動画参照）はJavaFXで書いている
- ごちそうフォト. 最近1位になりました（スイーツ王）

### Virtual Machineとは
- "Virtual Machine"といってもいくつか意味がある（今回は下記後者）
  - ホストOSの上にゲストOSを乗せる
  - プログラミング言語を解釈してコンピュータで実行するソフトフェア

#### VMを使うと嬉しいこと
- **Write Once, Run Anywhere**
- どこでも動く（windows, Mac, linux）
- OSによらず実行できるので"仮想"バーチャルマシン

### Java Virtual Machine
- バイトコードを解釈して実行
- 基本はインタープリタ = 1行ずつ読み込んで実行
- 反対はコンパイル言語（C, C++）
- JVMは実行時コンパイル（Just-in-Time Compile）
  - 今日は実行コンパイルは触れない（難しいから）
  - でもインタープリタ理解できれば理解できる. 

### Today's Sample
mainメソッドの中でadd関数. add関数は足し算するコード.
```java
public class Test {
  private int add(int x, int y) {
    int z = x + y;
    return z;
  }
  public static void main(String... args) {
    Test test = new Test();
    int z = test.add(10, 20);
  }
}
```

### Classファイル作成までの流れ
- .java -> javacコンパイラ -> .class
- .java
  - クラス定義
  - フィールド定義
  - メソッド定義
- .class
  - クラス定義
  - フィールド定義
  - バイトコード　（メソッド定義はこれに変換される）
  - 定数プール：文字列, リテラルがいっぱい入っている. 再利用できるように. 
  - 属性：その他雑多なものジェネリックスのパラメータなど

### javap
- バイトコードの逆アセンブル
- javap -option クラス名（-p : privatメソッドも対象に.  -c : バイトコード出力, -v バイトコード + 定数プール）
- アセンブラみたいなコードが出てくる. 
  - バイトコード
  - Java仮想マシン仕様という本に書いてある. 
  - [wikipediaにも書かれているので](http://ja.wikipedia.org/wiki/Java%E3%83%90%E3%82%A4%E3%83%88%E3%82%B3%E3%83%BC%E3%83%89)そっちを見てもいいかな. 

### mainを実行するまで
1. JVM起動
2. クラスロード
3. リンク
4. 初期化
5. main実行

#### 1.JVM起動
- JNI_CreateJavaVM()  // これが最初に実行されてJVMが起動される. 

#### 2.クラスロード
- classファイルの読み込み
  - 使用するクラスを芋づる式にロード
  - さっきのサンプルでも200個くらいクラス使う
- java -verbose:class Test
  - 読み込むクラスを見ることができる. 
  - rt.jarから呼ばれる. 巨大だからjava9から分割され, 使わないのは呼ばないようになる. 
- クラスロードだけでは読み込んだだけなのでまだ使えない

#### 3.リンク
- classファイルが正しいかチェック
  - 厳しくチェックしている
  - 改ざんされていないか
  - 悪意のあるコードがないか
- staticフィールドの初期化
  - ただしJavaコードの実行はしない
  - final修飾子が付いていても最初はnullが入る
- クラス間の関係を解決. 参照関係. 

#### 4.初期化
- staticフィールドの初期化
  - Javaのコードを実行する（参照関係が分かるので実行できるように）
- staticイニシャライザの実行
```java
static {
 // static initializer
}
```

#### 5.main実行
mainメソッドの実行

### クイズ
- Java Puzzle: Anniversary（詳しくは資料or動画）
- staticのところにも変な値が出るよ

### バイトコードの実行
- JVMはスタック
  - stack: Last in, First out (LIFO)
- 一般に実行形態は大きく分けて2つ
  - Stack Machine : 上から次々積み上げ　**JavaVM**, PostScript, .Net Framework CLR
  - Register Machine : 配列みたいなもので事前準備　Intel Core, ARM Cortex

#### 逆ポーランド記法
- 1 + 2 -> 1 2 +
- (2 + 3) * 5 + (4 - 2) -> 23 + 5 * 42 - +
- この書き方がだと括弧が出ない
- ポーランド記法もある
  - 1 + 2 -> + 1 2 
- 計算方法（中間の状態をスタックとしてもつ）
- **これをJVMでも同じことをやっている. **


#### 図解（詳細は資料or動画参照）
- 図
  - スレッド1, ... n, ... m
  - heap：オブジェクト
  - Metaspace(パーマネント領域）：クラスの情報, メソッドの情報

- スレッごとにスタックがある.（JavaStack）
  - PC : プログラムカウンタ
  - フレームというものを積んでいく
    - フレームはメソッド単位
    - **stack over flow** : スタックを積み上げすぎた結果

- フレームの中身もスタック
  - オペランドスタック
  - テーブルでローカル変数を持つ
- 逆ポーランド記法と同じことをやるのはオペランドスタック
- コンパイルした時にローカル変数の領域サイズは決まる. 
- ローカルへ直接値を詰めるのはプリミティブ. オブジェクトは参照情報（heapを見に行く）

- add関数を例にオペランドスタックを追いかける
```
private int add(int, int);
  descriptor: (II)I
  flags: ACC_PRIVATE
  Code:
    stack=2, locals=4, args_size=3
       0: iload_1
       1: iload_2
       2: iadd
       3: istore_3
       4: iload_3
       5: ireturn
    LineNumberTable:
      line 3: 0
      line 4: 4
```
- load, store
- iはintだから. 
- load_1, load_2(ローカル変数のインデックス)
- 自身も引数に取られる (0:this, 1: x:01, 2: y:20, 3: z: )

### まとめ
- マカロンスタック
  - マカロンは積むもの. 
- Java -> classファイル -> バイトコード
- 5つの手順: JVM起動, クラスロード, リンク, 初期化, main実行
- JVM: Stack Machine

## 後半（GC編）
### Why to use GC
- メモリの自動管理
- 不要になったメモリを自動的に回収
- ヒープの中にオブジェクトを配置

### Before GC
- 自前でメモリ管理
- C言語 malloc(), calloc(), realloc(), free()
- 問題点
　- メモリの解法忘れ
　- 二重解放
　- 無効な参照
  - メモリ周りのBUGは修正が難しい

### 歴史
- 1959: John McCarthy Mark & Sweep GC（Lisp向け）
  - 当時はとてつもなく遅かった. 
  - 一般的に使用されだされたのは90年代
  - でもまだ遅い部分も. 
- 2000年代から早くなってきて意識しなくても良いように. 
  - CPU, Memory性能向上

### GCの種類
#### アルゴリズム
- 基本
  - **Mark&Sweep**
  - 参照カウント
  - **Copy**
- 複合
  - **世代別**
  - G1

#### 運用
  - **Serial**
  - incremental
  - concurrent
  - parallel
  
Javaが提供していないもの : 参照カウントだけ. 他は全部入っている. 

- 今回の説明 : 世代別（Mark&Sqeep + copy）
  - いずれもserialで説明. 

### Mark & Sweep
- heap上のオブジェクトに対して使っているものをマーク, マークしていないものを掃除. 
  - 使用中のオブジェクトをマーク（markフェーズ）
  - マークの内オブジェクトを掃除（sweepフェーズ）
- どうやってマークをするのか. 
  - はじめにRootがある. rootから参照を辿る. 
  - rootから芋づる式にマーク
  - 先頭から未使用objをfree listへ
  - 隙間を埋めてくれない. 大きいオブジェクトがきたらOOM. 
- Mark&SweepGCを少し拡張してCompactionを導入. メモリを詰めることで細分化を解消. 
  - Mark&SweepとCompactionを合わせて使うことが多い. 
- 利点:
  - 実装がシンプル.
  - 参照の書き換えがないため, 安全（if not Compaction）
- 欠点:
  - stop-the-worldの時間が長い
    - stop-the-world : GCする際は処理を完全に止めなければならない
  - ヒープの断片化が起きやすい. （if not Compaction)
- どの言語でも一番初めにつくるのはMark&SweepGC

### Copy
- ヒープを二分割. 使用する領域は一方のみ. 
- 片方からもう一方へobjをコピー. 使用する領域を反転. 
  - fromがいっぱいになってきたらfromから使っているのをマーク. toへコピー. 
  - fromとtoを入れ替える. （compactionと同じようなことができる）
- MarkはするけどSweepはしない. 
- 参照の移動がするのでやや難しい. （詳細は本にて）
- 利点:
  - stop-the-worldの時間が短い.
  - ヒープの断片化が起きない.
  - 高速なアロケーション
- 欠点:
  - ヒープの使用効率が悪い（2分割するので）
  - 参照書き換えがある. 

### 世代別GC
- 考え方: 若いobjほど早く死ぬ
- 世代別にヒープ管理を行う
  - young世代：高速なGC（頻繁にGC） <- **Copy**
  - old世代：安定したGC <- ** Mark&Sweep**
- 新しいアルゴリズムがあるわけではなく, 世代別に適用するアルゴリズムへ変えた.
- objの年齢：GCを生き延びた回数

### 領域
- young: Eden, Survivor1, Survivor2
  - copyGCのfrom, to = Suvivor1, Suvivor2
- old: Tenured 

実際はoldの方が領域がyoungより10倍大きい

#### アルゴリズム
- 新しいobjはEdenへ配置. 
- edenがいっぱいになってきたら, マークしてedenからsuvivor1へ移動.
- edenがいっぱいになってきたらマークして（eden, suvivor1も）, edenとsuvivor1をsuvivor2へ移動. 
- edenがいっぱいになってきたら...（eden, suvivor2）, edenとsuvivor2をsuvivor1へ移動.
- 閾値を越えたらtenuredへコピー. 

### 世代別GC
- Mark&Sweepとcopyのいいとこどり
- 領域サイズはチューニングが必要
  - old世代のGCをなるべく減らす
- CMS, G1GCなどの派生GCあり

### まとめ
- Mark&Sweep, Copy, 世代別
  - アルゴリズム的には60年代からずっとこれ. 
- 原理を知って, チューニングに活かす
  - 設計の時の指針になる. 
- GCは腫物扱いされるかもしれないけどGCは友達！

## 所感
- javap, java verbose:classとコマンドやオプションを知ることができた.
  - これを使えば自分自身でも処理の流れを追うことができる. 意外と簡単.
- static(static final)でも挙動がおかしく見えるようなことがある（仕様を知っていれば大丈夫）
- Eden, Survivor, Tenured. 聞いたことはあるけど, 実際のフローは分からなったが, 今回でよく理解できた.

# 基本情報
開催日: 2015/04/08 Wed  
開催場所: 東京国際フォーラム  
イベントURL: http://www.oracle.co.jp/jdt2015/ ([セッション一覧](https://www.oracle.com/webfolder/s/delivery_production/docs/FY15h1/doc12/JavaDayTokyo-2015-agenda.pdf))

# 参加セッション
- 基調講演
- NetBeansとGlassFishではじめるJava EE7ハンズオン・ラボ
- IT課題の解決に向けたJava EEセントリックな開発標準化の勘所
- エンタープライズ・アーキテクチャの選択について
- Java EE 7適用のための7つのポイント
- Java 20周年記念セッション
- Java Day Tokyo Night
- その他

# 購入図書
- [Javaパフォーマンス](http://www.oreilly.co.jp/books/9784873117188/)  
- [コンピュータシステムの理論と実装――モダンなコンピュータの作り方](http://www.oreilly.co.jp/books/9784873117126/)
- [Javaエンジニア養成読本](http://www.amazon.co.jp/exec/obidos/ASIN/4774169315) (後日購入)

# メモ
## 基調講演
### 資料
動画: http://www.oracle.co.jp/jdt2015/ (いつまで見れるか分からないので注意)

### 内容
- 新産業革命. 人類70億人に対して, Java動作デバイス90億台.
- 原人 -> エンジン -> 電気 -> IT(Java)
- 日本少子化とグローバル化. 人口減少. ITによる生産性の向上が急務
- Oracleの考えるクラウド -> 全部クラウドへ
- Java開発者: 900万人
- [Oracle Java Cloud Service](https://cloud.oracle.com/java)
- 発展にコミュニティ不可欠. 日本のコミュニティ2つ.
  - [JJUG](http://www.java-users.jp/)
  - [関ジャバ](http://kanjava.connpass.com/)
- 去年Java8リリース(現在はJava 8u40)
  - ラムダ
  - ストリームAPI
  - Fork Joinのパフォーマンス向上
- 書籍もたくさん. 日本語のもたくさん.(80冊)
- Java SE 8資格試験(ブロンズ, シルバー, ゴールド) 2015/05/28 
- [pepper](http://www.softbank.jp/robot/products/)のデモ. Java SDKによって開発可能.
  - [秋葉原アトリエ](http://pepper-atelier-akihabara.jp/)
- Java9 2016年
- JavaEE8 2016年
- 教育に注力 (Java for kids/Java for students)

### 所感
- 車のデモ好きですね
- 来年も資格…
- pepper間近で見てみたい

## NetBeansとGlassFishではじめるJava EE7ハンズオン・ラボ
### 資料
特になし (参加者にPDF配布)

### 内容
- 本ハンズオン・ラボでは新機能の一つである WebSocket にフォーカスをあて、より現実的な WebSocket アプリケーションの構築を行います。
- 使用技術
  - Java Message Service 2.0 (JSR 343)
  - JavaServer Faces 2.2 (JSR 344)
  - Enterprise Java Beans(JSR 345)
    - Singleton EJB
    - Message-Driven Bean
    - Contexts and Dependency Injection 1.1 (JSR 346)
    - Java API for WebSocket 1.0 (JSR 356)
    - Batch Applications for the Java Platform (JSR 352)
- 使用ソフトウェア
  - Java SE 8u40
  - NetBeans 8.0.2

#### 所感
- こういうイベントでは初めてのハンズオンだったりする.
  - 意外とハードルは低い. (席争奪戦のハードルは高い)
- 講義というよりは自習. PDF通り淡々と進める.
  - なのでWebSocketそのものの理解が深まった, というよりは"使い方"が理解できた.
- さすがIDE. マウスだけでどんどんコーディングが進む.
- NetBeansそのものの感触も良い感じ. おそらくEclipseから乗り換える.
- GlassFishの管理画面かっこ良くて見やすい

## IT課題の解決に向けたJava EEセントリックな開発標準化の勘所
### 資料
特になし

### 内容
#### アジェンダ
- 企業におけるITの課題とこれまでの取組
- Java EEセントリックな開発標準化
- 開発標準化でJavaEEをうまく使う勘所
- まとめ

#### 企業におけるITの課題とこれまでの取組
- IT課題の改善がなかなか進まない
  - 生産性が上がらず, 品質不安定 -> 昔から
  - 運用に手間とお金がかかる -> 昔から, というよりここ数年
  - 社内の技術者育成が進まず, リテンションも難しい -> 育成した技術者を社内にどう留めるかという課題も
- 課題に対して取り組みが各社で行われた
  - 2000年台諸島にJ2EE開発標準化ブーム
  - 多数の独自フレームワーク(俺様フレームワーク)乱立
  - 現在も継続利用されているケースが多い
  - サードパーティ製フレームワークでJ2EEの不足を補完するアプローチ (OSS + カスタム開発)
- よりいっそうのITコスト削減が要求される -> 独自フレームワーク路線の継続は難しい状況へ
- ユーザ企業と開発ベンダがそれぞれ所有するフレームワークのミスマッチ
- 十分なコスト削減が実現できない
  - ユーザ企業のフレームワーク: 開発コスト大きい
  - 開発ベンダのフレームワーク: 運用コスト大きい
- オープンソース製品へのロックインのリスクが露呈し始めた
  - ここ数年, オープンソースへの"ロックインへの"リスク
  - JavaEEに追いぬかれて陳腐化
- プロジェクトのEOLやセキュリティ脆弱性問題への対応に依るコストの増大
  - 日本だとStrutsを多用して...大変になっている

#### Java EEセントリックなアプリケーション開発標準化
- オープンソースプロジェクトの成果を取り込んでJavaEEはフルスタックのフレームワーク機能を提供
  - JavaEE5までは利用拡大に向けた大幅な機能の進化
  - JavaEE6から成熟
- JavaEEを使うとどうなるか
  - サードパーティ製フレームワークでの補完は不要
  - 進化したJavaEEを「素で使う」構成へシフト
- JavaEE標準フレームワークを使うことのメリット
  - 各ベンダのフレームワークのミスマッチを解消
  - メンテナンス不要
  - 学習可能. 一般書籍や社外の技術コミュニティの情報を活用した技術者育成や問題解決が可能に
- 見直しを進めている企業が多い
  - どうしてこのタイミング？ -> 近年, 開発内製化の意識向上, 活発化

#### JavaEEをうまく使う勘所
- JavaEEは「標準」と「後方互換性」を最大メリットとする安定したプラットフォーム
- これまではサードパーティ製フレームワークを入れていたので崩れていた

- 均質化
  - 各アプリケーションがJavaEEマルチティアモデルに準拠し、同じ粒度・同じ役割でコンポーネントを分割
  - コンポーネント間の関連を疎結合化してモジュール性を担保
  - 標準APIベースの開発でアプリケーション長寿命化
- サードパーティ製品は疎結合利用してロックインを開発
- JavaEE標準アーキテクチャはJSF + EJB + JPAで決まり!
- 各コンポーネントの作りのばらつきを抑えれば標準化はさらに前進
  - Faceletsテンプレート（ヘッダとフッタを使う）
  - 画面とバッキングビーンが1対1対応（Strutsの人が好む）
- パターンの組み合わせでアプリケーション構成を記述しさらにパターン化して再利用
- **パターン化**
  - 非機能要件の実現方法もパターン化
  - 運用管理のツールや対応手順もパターン化
  - UIのコンポーネントもパターン化
  - ログイン/コンポジットコンポーネント
  - パターンベースの技術習得で技術者の育成を大幅にスピードアップ
- パターンベースの技術習得
  1. よく利用するパターンの組み合わせの理解からはじめ
  2. 利用するパターンの設計/実装で使われている技術を深堀りし、
  3. 関連する技術や代替技術へ学習範囲を拡大

#### まとめ
- JavaEE標準機能をダイレクトに利用してJavaEEの安定したプラットフォームのメリット最大活用
- パターン化して再利用
- パターンベースの設計/実装
- パターンベースの学習
- フレームワークはあくまでサポート. ものに引っ張られるのでないように

### 所感
- 怒涛のパターンラッシュ
  - でもパターン大事. 共通の意志を持っていれば円滑な開発が可能に.
- サードパーティ製のものを使用するとメンテが大変なのでJavaEE使いましょう

## エンタープライズ・アーキテクチャの選択について
### 資料
http://www.slideshare.net/yusuke/java-daytokyo2015-64share

### 内容
- アーキテクチャとはなにか
- どうやったら選択したら良いのか

#### アーキテクチャとは
- システムの「わけかたと組み合わせ方」のこと
- 簡単に言うと「システム全体のバランスを取る」こと
  - 空間的: 利害関係者の関心ごとを意識する
  - 時間的: 現在から未来の時間経過に伴う変化を意識する

#### アーキテクチャの成果とは
- システムの「構造とプロセスの決定」
  - 構造: システムの機能が, どのような要素に分解されるのか
  - プロセス: それら要素をどのように組み立てるのか
- 上記にリソースとスケジュールを加味するとWBS（ガントチャート）になる

#### エンタープライズ・アーキテクチャとは
- 企業システムを大賞としたアーキテクチャ
- 特徴
 - 利害関係者が多い（かつ、縦割り）
 - 連携先システムが多い
 - 急激に変化できない/しない
 - 現状維持が重要
 - 様々なシステム (B2B, B2C, B2E)
 - 様々なルール（内部統制、セキュリティ,法制度）

#### なぜアーキテクチャを定義するのか
- アーキテクチャが全てのスタート
  - 構造とプロセスが明確でなければチームは動けない
  - プロジェクトマネジメントはアーキテクチャを前提とした実行段階におけるPDCAの営み
- 最初に全てを固定的に決める必要はない

#### 選択の観点
- 本日は3つの観点を紹介
  - ITサービス運営の観点
  - 品質の観点
  - 技術の観点
- どんなアーキテクチャが良いのか, という紹介ではなくどのようにアーキテクチャを選択するか抽象度を上げて説明します
- ITサービス運営の必要性
  - 「アプリケーションを作る」から「ITサービスを運営する」へ
    - 昔ながらの体制: アプリケーションを作る, だけ.
    - 現代だと仕様が完全にはかたまっていない, フィードバッグを受けて洗練していく.
    - アジャイル, リーンスタートアップという文脈でよく言われる.
    - どんどんサービス運営の割合が増えていっている.

#### ITサービス運営モデル
スライドの図を参照.
- 構造, プロセス, 機能, ITサービス
- ユーザがサービス(ITサービス含む)を受けて満足度を示す
- 運用, 業務, 開発, 企画: それぞれが違うところに興味がある
  - 開発: 機能
  - 運用: ITサービス
  - 業務: ITサービス, サービス
  - 企画: サービス, 満足度
- 例) プロセスがｇｄｇｄだとすると機能に影響が -> ITサービスが悪くなり -> 満足度が下がる(互いに影響をおよぼす)

#### ITサービス運営モデル
- より「ITサービス運営」を意識したアーキテクチャ設計になっていく必要性がある
  - 利害関係者はさらに多く
  - ユーザが利用することで評価
  - 様々な要素の相互関係によって成り立つ (一個駄目なら全部駄目, 一個良くしても全部は良くならない)

- DevOps : 開発と運用の結びつき
- リーンスタートアップ : 企画と開発の結びつき

#### IT/ソフトウェア品質特性
- 品質とはなにか？
  - 品質とは多面的
  - いくつかの観点でバランスを取りながら検討を勧める
- 品質特性: 経済産業省が出している
  - http://www.meti.go.jp/policy/mono_info_service/joho/cloud/2011/11_04.pdf
  - http://www.meti.go.jp/policy/mono_info_service/joho/cloud/2011/11_03.pdf
- 技術選択において, 品質特性どうしが打ち消しあう場合もあるため安易な両立は避けるべき
- 特筆するならば
 - コストの観点では保守性が重要
 - 性能効率性は仮想化/クラウドによって少し自由に
   -> 5年後のユーザの試算を..とは言わなくなった
 - 互換性はあらゆるシーンで重要
 - エンタープライズでは信頼性とセキュリティが重要

#### 技術
- 企業の中の位置づけが非常に重要
- 共有と固有のバランス
   - 共有された資源を最大限に活用

#### プラットフォーム
- SaaS, PaaS, IaaS
- どのレベルで共有資源として定義するか
- 共有し過ぎると対応できないことが

#### マイクロサービス
- サービスに寄ってシステムを構成する
- サービスどうしは独立した構造とプロセスを持つ

#### 選択の実践
- 分かりやすい例としてECサイト
  - エンタープライズ的でありながらWEB的
  - WEB的でありながらエンタープライズ的
- 多面的に組み立てることが大事
- 完璧な選択はできない
  - すべての要素に利害関係者がいることを理解しておくこと

#### 選択の覚悟
- アーキテクトはアーキテクチャを決定する重要な役割を背負う
- 正解がないからこそ覚悟が必要
- 最小公倍数ではなく最大公約数を目指す
- 決定は「誰か」のものではなく自分のものだという責任
- 銀の弾丸はない.
- 誰かの成功事例が自分に当てはまるとは限らない
- 銀の弾丸を込めたら撃ちぬくまで辞めないのが責任
- 妥協は出来ないが, 適切に諦めること

#### まとめ
- アーキテクチャとはなにか
- ITサービス運営モデル
- 品質特性
- 何を固有化して何を固有化しないか
- アーキテクトの覚悟と責任

- アーキテクチャ設計の観点は変化している. 今日の観点も正解ではない.
- チームでアーキテクチャに取り組もう. よりよい選択のための継続的な努力を.

### 所感
- "最小公倍数ではなく最大公約数を目指す"の言葉が刺さった
  - 全員の要望を全て受け入れるのでなく, 全員の要望に共通するものだけを採用するということ. 
  - コストは有限なので全員にどこかしら我慢してもらう必要がある
- 登場人物は4人(運用, 業務, 開発, 企画). 彼らが相互に理解し合うことが大事.
  - 組み合わせによって最近耳にする言葉と結び付けられるのが面白い
    - DevOps : 開発 & 運用
    - リーンスタートアップ : 企画 & 開発
- 経済産業省が出している品質特性はよく網羅されており, チェックシートとして活用できるらしい.

## Java EE 7適用のための7つのポイント
### 資料
http://www.slideshare.net/iwasakihirofumi/seven-points-for-applying-java-ee-7

1. EE7のベースのアプリケーションサーバを考える必要あり
   - 世の中にはEE7のアプリケーションサーバが多数存在
   - EE7に対応しているサーバ4つ
     - 選択肢が多いのは良いこと
     - 理想と現実を吟味して選択すること
     - ポリシー, ロードマップ, リソースを考慮してアプリケーションサーバを選ぶこと
   - EE6はあまりおすすめしない

2. モダンなIDE, Mavenをうまいこと使ってプロジェクトを進める
  - 10,000のクラスがあるのでテキストエディタは無理. IDEを使いましょう.
  - モダンなIDEを使う(NetBeans, IntelliJ, eclipse)
    - 日本だとやたらeclipse. 世の中だと3すくみ状態.
  - リポジトリもGitを使う.
  - ツールの中にビルドツール
    - AntはやめてモダンなビルドツールMaven, gradle
      - maven : 簡単
      - gradle : 複雑なことも書ける. 経験者がいない
  - IDEのサポート状況. mavenは全部サポートしている. gradleはプラグインで.
  - mavenだと独自の.projectは作らない. 特別なインポートもいらない. -> 人によって好きなIDEが使える
  - だからmaven使うのがおすすめ. 好きなIDEを使って楽しむ.

3. フロントエンドフレームワークにJSFを使う
  - Strutsはやめる
  - JSF JavaServer Faces. viewベース.
  - 一方でStrutsはアクションベース(分かりづらい)
  - JSFはASPのモデルを使っている
    - 画面とバッキングビーンが1対1に結びついている
    - ボタンが3つあったら3つメソッドがあるような感じ
  - ただしStrutsからJSPへの移行は超面倒. 諦めて作りなおすか, EE8まで待つこと.
    - EE8でMVC1.0をサポート
  - Strutsの時代はJSPを使っていた
  - JSFはJSPは無い -> 書きなおしてリロードするとすぐに修正反映されている. PHPに追いついた.
  - EE6までへんてこなHTMLフレンドリータグが残っていた(覚えられない)
  - EE7からはシンプルに. タグを覚えなくても良くなった.

4. バックエンドフレームワークとしてEJBを使いましょう
  - アプリケーションの内容は全てEJBに集約されている
  - EJBの一番良い所: トランザクションマネージメント
  - インスタンスのプール -> クライアントから呼ばれるときに真価を発揮
  - 標準で付いているところがでかい
  - バッチをJavaで書く
    - 選択肢3つ
      1. EJBを使いましょう
      2. JavaBatchフレームワーク  
      3. JavaEEサーバを使わない. POJOで. （非推奨）

5. リモート接続の考慮
  - データベース
  - JPQL
  - CriteriaQuery

6. データベース永続化にJPAを使いましょう
7. EE8の先を考えてデザインしましょう

### 所感
- 昔酷評されたEJB. いまは最高に使いやすくなっているらしい.
- MVC1.0. むしろこれまで標準仕様が無かったのが驚き
- EJB, JSP, JSF...3文字が多くてややこしい. 覚えなければ.
- "EE6までへんてこなHTMLフレンドリータグが残っていた"はたしかに...新人研修で「？」だった覚えがある
- rails並に作りやすくなっていそう？

## Java 20周年記念セッション
- お弁当 + ビール
- 名刺交換. (あとで見返すとすごい肩書ばかり...)
- クイズは散々でした. 内容は半分ほどおっさん向けらしい.
- [Javaエンジニア養成読本](http://www.amazon.co.jp/exec/obidos/ASIN/4774169315)が良いらしい.
  - 後日読みました. 歴史から最新のJavaまで幅広くかつサクッと学べる良書.
- ビールはゆっくり飲むと酔いやすい

## Java Day Tokyo Night
- Dukeケーキ頭からバッサリ
- 一口にJavaといっても本当に多方面で使われていることを知った

## その他
- 企業ブース回って資料だったりステッカーだったり入手
- IntelliJ IDEAのデモが素晴らしかった.
  - 動作が軽い
  - ポストプレフィックス的にどんどん入力補完
  - 乗り換えたかったけど機能をフルに使うには有料...
- Dukeと記念撮影(facebook投稿)
- 肝心のJavaのステッカーはもらえてない

# まとめ
- 2014年後半〜2015年初頭までJavaを思い出しながら生きていました
- だから今回のイベントはこれまでよりもすっと頭に入ってきたような気がします
- 新人研修(3年前)よりはるかに開発しやすくなっているのを実感
  - 特にWebアプリケーション開発は快適そう 
- 様々なIDEを知れたのが一番の収穫
  - 二番目は懇親会参加
  - 三番目は発売前のオライリー本が買えたこと
- 継続的にイベントに参加すると新しい情報だけに集中して聞ける
  - 今回の基調講演はけっこう既知なことが多かった
  - 今後も追っかけていきたい

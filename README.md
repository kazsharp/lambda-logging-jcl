## lambda-logging-jclとは？

Log4j2のApache Commons Loggingブリッジの実装です。
Log4j2にはすでにcommons-logging用のブリッジが用意されていますが、それらのクラスを継承して引数にlambda式を取るメソッドを追加しています。
lambda式は遅延実行されるため不要な文字列生成を行わないようにすることが可能です。
例えば、コストのかかる文字列を生成する```highCostString()```メソッドがあったとします。
そしてログレベルがDEBUGの時のみ出力したい場合、
```java
  if (LOG.isDebugEnable()) }
      LOG.debug(highCostString());
  }
```
のようにすることで無駄な文字列生成コストを避けるのはよくあるイディオムだと思います。
ただ、上記のコードは
* JUnitでのカバレッジ(C1)が下がってしまう
* そもそもif文が乱用されるのがうっとうしい
などの問題があります。

lambda-logging-jclを使うことで、上記のコードを下のように記述することができます。
```java
  LOG.debug(() -> highCostString());
```
このコードはif文によるログレベル判定がありませんが、lambda式の遅延処理によりログレベルがINFO以上の場合にも無駄な文字列生成コストがかかりません。
また、commons-loggingブリッジを継承しているので、commons-loggingを使っているシステムに透過的に適用することができます。

## インストール
```xml
  <dependency>
    <groupId>jp.gr.java_conf.kazsharp</groupId>
    <artifactId>lambda-logging-jcl</artifactId>
    <version>0.0.1</version>
  </dependency>
```
※log4jを実行するにはlog4j-coreも必要です（lambda-logging-jclは直接依存していないのでmavenは自動で解決しません）

## 使い方
commons-loggingのLogオブジェクトを```LambdaLog4jLog```にキャストします。
```java
	static LambdaLog4jLog LOG = (LambdaLog4jLog)LogFactory.getLog(Hoge.class);
```
commons-loggingのLogクラスの各メソッドのメッセージ部分を文字列を生成するlambda式で記述します。
```java
	LOG.info(() -> "波動拳" + "昇竜拳" + "めくり大キックアッパーキャンセル昇竜拳");
	
	LOG.error(() -> "大ゴスしゃがみ中キックキャンセル真空波動拳", e);
```
## LICENSE
This software is released under the Apache License, see LICENSE file
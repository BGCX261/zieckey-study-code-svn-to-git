2006/12/09
Eclipse使用：
下载:www.eclipse.org/downloads
下载中文支持插件:
download.eclipse.org/eclipse/downloads
这个页面有个: Language_Packs


安装JDK,
然后解压eclipse-SDK-3.2.1-win32.zip,解压后就可以直接用了.
如中文支持插件也放在同一目录中,那么缺省的语言就是中文了,
这时如果想切换回英文,可以发送一个快捷方式到桌面:
右键选择"属性"编辑"目标"在后面添加: -nl en ,如下:
"C:\Program Files\Java\eclipse\eclipse.exe" -nl en
另外还可以通过这种方式指定工作目录,加上 -data 参数就好了
"C:\Program Files\Java\eclipse\eclipse.exe" -nl en -data f:\workspace

查看 eclipse 是否找到了电脑上安装的 jre 环境:
点击"Windows->Preferences->Java->Installed JREs"
如果没有找到,可以选择"Add..."
然后自己选择一个"JRE home directory:"



编译第一个Eclipse的Java程序.

File->New->Project...
选择 Java Project 后，点击 Next，输入工程名字：hello，点击 Finish ，就创建拉一个工程。
在左边Workspace中看到hello这个字符串没？
右键点击它，File->New->Source Folder，输入src，点击Finish，这样就建立了一个Source文件夹。
右键点击我们刚建立的 src 文件名 ，选择New->Class,输入类名字：hello，点击 Finish。
这个时候在Eclipse的中间出现了编辑界面，输入一下内容：
public class hello {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println( "Hello world! My Java!" );
	}

}

保存，现在可以编译了。
在左边Workspace中看到 hello.java 这个字符串没？
右键点击它，选择 Run as -> 1 Java Application 这样就可以编译拉
在Eclipse的中下部的Console对话框中输出：
Hello world! My Java!
是不？


让第三方jar包添加到eclipse环境中
Project->Properties->Java Build Path->Libraries 选择 Add Extenal JARs，然后就可以选择第三方jar包

Eclipse自动构建功能让我们编译程序很快的就可以完成，
这是因为每次我们保存文件的时候，Eclipse就帮我们自动编译了。
当然我们也可以取消这个自动构建功能：
取消 Project->Build Automatically 前面的勾，就可以取消自动编译功能

我们还可以清理编译过的中间文件，选择 Project->Clean 就可以了


Java的调试：
{
	设置断点：
	在编辑区域的左边框上双击就可以创建或删除断点
	或者编辑区域的左边框上右击选择Toggle breakpoint来设置断点.
	选择 Debug As 就可以调试程序了

	察看变量值:
	选中变量然后右击选择Watch就可以了,或者选择 Window->Show View->Display,
	在Display窗口中输入想要查看的变量就可以了.

	从调试状态回到原始编辑状态:先停止调试运行,
	然后选择右上角的Java标签就可以回到Java Perspective

	设置条件断点：
	在断点上右击，选择 breakpoint Properties->Enable Condition,
	然后在Enable Condition下的输入框中输入条件就可以了。

	异常断点：
	在debug视图中的Breakpoints界面上有一个Add Java Exception breakpoint按钮，
	可以添加出现异常的断点，这样程序出现异常时，会在程序异常的地方停下来
}


当Eclipse提示代码中出现错误或者警告是，尝试着电击那个红色的叉叉或黄色的小东西，
这样会弹出一些有用的编辑选项，我们双击相应的选项会快速帮我们解决这些错误或警告。

自动生成set、get方法的功能：
{
	假如我们有这样一个类：
	public class PersonInfo {
		String name;
		int age;
	}
	现在我们想为它添加set、get方法，那么可以选择：Source->Generate Getters and Setters...
	选择后，就可以看到Eclipse为我们生成了set、get方法，如下：
	public class PersonInfo {
		String name;
		int age;
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
	}

	这里还可以为我们生成构造函数，那么可以选择：Source->Generate Constructor using Fields...
	选择后，就可以看到Eclipse为我们生成了构造方法，如下：
	public class PersonInfo {
		String name;
		int age;
		public PersonInfo(String name, int age) {
			super();
			this.name = name;
			this.age = age;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
	}

	也可以生成重载父类的构造函数Source->Generate Constructor From superclass...
}

自动生成JavaDoc
{
	/**		注明：在此处按Enter键
	public PersonInfo(String name, int age) throws IOException {
		super();
		this.name = name;
		this.age = age;
	}

	就会自动帮我们生成注释：
	/**
	 *
	 * @param name
	 * @param age
	 * @throws IOException
	 */
	public PersonInfo(String name, int age) throws IOException {
		super();
		this.name = name;
		this.age = age;
	}
}

代码的自动完成：Alt+/
代码格式化功能：Ctrl+Shift+F
	这里可以自定义自己的格式：window->Properties

jar包关联源代码：Attach Source
快速打开文件：Navigate->Open Type...
打开一个类的继承关系：在编辑器中选择该类，右键选择“Open Type Hierarchy”
打开方法调用,方法被那些地方调用了:编辑器中选择该方法，右键选择“Open Call Hierarchy”

Eclipse高级操作:远程调试
JPDA

Eclipse插件的安装:
1. 在线安装:
一次选择Help->Software Updates->..........
之后就是输入网址就可以了
2. 直接解压安装，如果没有安装成功，就可以将eclipse的安装目录下的configuration\org.eclipse.update目录删除就会让eclipse去更新插件。
3. 用link的方式安装
先把插件解压到同一目录如：
d:\Myplugins
一定保持响应的目录结构,如Lomboz:
Lomboz\eclipse\features
Lomboz\eclipse\plugins

在eclipse的目录中建立一个links目录
并建立一个Lomboz.txt 内容如下
path=D:\\Myplugins\\Lomboz

或者
path=D:/Myplugins/Lomboz
（注意这里是反斜杠/，而不是\）
说明：
	1. 插件可以分别安装在多个自定义的目录中。
	2. 一个自定义目录可以安装多个插件。
	3. link文件的文件名及扩展名可以取任意名称，比如ddd.txt，myplugin都可以。
	4. link文件中path=插件录的path路径分隔要用\\或是/
	5. 在links目录也可以有多个link文件，每个link文件中的path参数都将生效。
	6. 插件目录可以使用相对路径。
	7. 可以在links目录中建立一个子目录，转移暂时不用的插件到此子目录中，加快eclipse启动。
	8.  如果安装后看不到插件，把eclipse 目录下的configuration目录删除，重启即可。


常用插件:
数据库管理:SQLExplorer
GUI:SWT-Designer
反编译:Jode
J2EE:Lomboz,MyEclipse
XML:XMLBuddy




public class hello {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println( "Hello world! My Java!" );
	}

}

保存，现在可以编译了。
在左边Workspace中看到 hello.java 这个字符串没？
右键点击它，选择 Run as -> 1 Java Application 这样就可以编译拉
在Eclipse的中下部的Console对话框中输出：
Hello world! My Java!
是不？









2006/12/17
孙鑫Java无难事---1
JDK：Java Develop Kit ，即Java开发工具包
JRE：Java Runtime Environment，即Java运行环境

J2SE：http://java.sun.com/j2se/1.4.2/download.html
J2EE：
J2ME：

http://java.sun.com/j2se/1.4.2/download.html
下面有Java 2 Platform、Document下载
另外，http://java.sun.com/docs/books/tutorial/information/download.html开发指南

开发指南和帮助文档是单独下载的.



Java来自于Sun公司的一个叫Green的项目，其原先的目的是为家用消费电子产品开发一个分布式代码系统，这样我们可以把E-mail发给电冰箱、电视机等家用电器，对它们进行控制，和它们进行信息交流。开始，准备采用C++，但C++太复杂，安全性差，最后基于C++开发了一种新的语言Oak（Java的前身），Oak是一种用于网络的精巧而安全的语言，Sun公司曾以此投标一个交互式电视项目，但结果被SGI打败。可怜的Oak几乎无家可归，恰巧这时Mark Ardreesen开发的Mosaic和Netscape启发了Oak项目组成员，他们用Java编 制 了HotJava浏 览器，得到了Sun公司首席执行官Scott McNealy的支持，触发了Java进 军Internet。 Java的取名也有一则趣闻，有一天，几 位Java成员组的会员正在讨论给这个新的语言取什么名字，当时他们正在咖啡馆喝着Java(爪哇)咖 啡，有一个人灵机一动说就叫Java怎 样，得到了其他人的赞赏，于是，Java这个名字就这样传开了。

因为Java是
简单的
{
	Java最初是为对家用电器进行集成控制而设计的一种语言，因此它必须简单明了。Java语言的简单性主要体现在三个方面：
	             1、Java的风格类似于C++，因而C++程序员初次接触Java语言，就会感到很熟悉。从某种意义上讲，Java语言是C及C++语言的一个变种，因此，C++程序员可以很快地掌握Java编程技术。
	             2、Java摒弃了C++中容易引发程序错误的一些特性，如指针、结构、枚举以及内存管理等。
	             3、Java提供了丰富的类库，可以帮助我们很方便的开发Java程序。
}
面向对象的
{
面向对象可以说是Java最重要的特性，所以它支持继承、重载、多态等面向对象的特性。Java语言的设计是完全面向对象的,它不支持类似C语言那样的面向过程的程序设计技术。
}
健壮的
{
Java致力于检查程序在编译和运行时的错误。Java也是一种强类型的语言，其类型检查比C++还要严格。类型检查帮助我们检查出许多开发早期出现的错误。Java自己负责内存管理，提供了垃圾内存回收机制，有效的避免了C++中最头疼的内存泄漏问题。

}
安全的
{
Java的安全性可从两个方面得到保证。一方 面，在Java语言里，删除了指针和释放内存等C++功能，避免了非法内存操作。另一方面，通过Java的安全体系架构来确保Java代码的安全性。当我们从网上下载Java代码在本地执行时，Java的安全架构能确保恶意的代码不能随意访问我们本地计算机的资源，例如：删除文件，访问本地网络资源等操作都是被禁止的。
}
解释的
{
Java代码是解释执行的，我们使用Java编译器将Java代码编译成字节码，这是一种中间代码，然后由Java解释器解释执行。而C++程序是编译执行的，C++程序代码被编译为本地机器指令，然后执行。
}
与平台无关的
{
Java作为一种网络语言，其源代码被编译成一种结构中立的中间文件格式。只要有Java运行系统的机器都能执行这种中间代码。Java源程序被编译成一种与机器无关的字节码格式，在Java虚拟机上运行。
}
多线程的
{
Java语言的一个重要特性就是在语言级支持多线程的程序设计。多线程就好像我们做一张桌子，如果你一个人完成这张桌子—就好像单线程，那么你需要先做桌面，做完桌面后，再做4个桌子腿，如果现在有5个人来做桌子—在程序中开辟5个线程，其中1个人做桌面，另外4个人分别做4个桌子腿，那么这两种方式效率的高低，相信大家都能区分出来。
}
动态的语言
{
Java的动态特性是其面向对象设计方法的扩展。它允许程序动态地装入运行过程中所需要的类，这是我们采用C++语言进行面向对象程序设计所无法实现的。在C++程序设计过程中，每当在类中增加一个实例变量或一个成员函数后， 引用该类的所有子类都必须重新编译，否则将导致程序崩溃。Java从以下几个方面采取措施来解决这个问题。Java编译器不是将对实例变量和成员函数的引用编译为数值引用，而是将符号引用信息在字节码中保存下来，传递给解释器，再由解释器在完成动态连接类后，将符号引用信息转换为数值偏移量。一个在存储器中生成的对象不在编译过程中决定，而是延迟到运行时由解释器确定。这样，对类中的变量和方法进行更新时就不至于影响现存的代码。 解释执行字节码时，这种符号信息的查找和转换过程仅在一个新的名字出现时才进行一次，随后代码便可以全速执行。在运行时确定引用的好处是可以使用已被更新的类，而不必担心会影响原有的代码。如果程序连接了网络中另一系统中的某一类，该类的所有者也可以自由地对该类进行更新，而不会使任何引用该类的程序崩溃。Java还简化了使用一个升级的或全新协议的方法。如果你的系统运行Java程序时遇到了不知怎样处理的程序，Java能自动下载你所需要的功能程序。
}

Java的跨平台是通过Java虚拟机（JVM）来实现的。Java的跨平台是通过Java虚拟机（JVM）来实现的。

Java源文件的编译过程
             Java应用程序的开发周期包括编译、下载、解释和执行几个部分。Java编译程序将Java源程序翻译为JVM可执行代码—字节码。这一编译过程同C/C++的编译有些不同。当C编译器编译生成一个对象的代码时，该代码是为在某一特定硬件平台运行而产生的。因此，在编译过程中，编译程序通过查表将所有对符号的引用转换为特定的内存偏移量，以保证程序运行。Java编译器却不将对变量和方法的引用编译为数值引用，也不确定程序执行过程中的内存布局，而是将这些符号引用信息保留在字节码中，由解释器在运行过程中创建内存布局，然后再通过查表来确定一个方法所在的地址。这样就有效的保证了Java的可移植性和安全性。

Java解释器的执行过程
              运行JVM字节码的工作是由解释器来完成的。解释执行过程分三步进行：代码的装入、代码的校验和代码的执行。装入代码的工作由“类装载器”（class loader）完成。类装载器负责装入运行一个程序需要的所有代码，这也包括程序代码中的类所继承的类和被其调用的类。当类装载器装入一个类时，该类被放在自己的名字空间中。除了通过符号引用自己名字空间以外的类，类之间没有其他办法可以影响其它类。在本台计算机上的所有类都在同一地址空间内，而所有从外部引进的类，都有一个自己独立的名字空间。这使得本地类通过共享相同的名字空间获得较高的运行效率，同时又保证它们与从外部引进的类不会相互影响。当装入了运行程序需要的所有类后，解释器便可确定整个可执行程序的内存布局。解释器为符号引用同特定的地址空间建立对应关系及查询表。通过在这一阶段确定代码的内存布局，Java很好地解决了由超类改变而使子类崩溃的问题，同时也防止了代码对地址的非法访问。
              随后，被装入的代码由字节码校验器进行检查。校验器可发现操作数栈溢出，非法数据类型转换等多种错误。通过校验后，代码便开始执行了。


Java字节码的两种执行方式
            1、即时编译方式：解释器先将字节码编译成机器码，然后再执行该机器码。         2、解释执行方式：解释器通过每次解释并执行一小段代码来完成Java字节码程 序的所有操作。 　　通常采用的是第二种方法。由于JVM规格描述具有足够的灵活性，这使得将字节码翻译为机器代码的工作具有较高的效率。对于那些对运行速度要求较高的应用程序，解释器可将Java字节码即时编译为机器码，从而很好地保证了Java代码的可移植性和高性能。


JVM规格描述
             JVM的设计目标是提供一个基于抽象规格描述的计算机模型，为解释程序开发人员提供很好的灵活性，同时也确保Java代码可在符合该规范的任何系统上运行。JVM对其实现的某些方面给出了具体的定义，特别是对Java可执行代码，即字节码(Bytecode)的格式给出了明确的规格。这一规格包括操作码和操作数的语法和数值、标识符的数值表示方式、以及Java类文件中的Java对象、常量缓冲池在JVM的存储映象。这些定义为JVM解释器开发人员提供了所需的信息和开发环境。Java的设计者希望给开发人员以随心所欲使用Java的自由。
            JVM是为Java字节码定义的一种独立于具体平台的规格描述，是Java平台独立性的基础。



Java程序执行与C/C++程序执行的对比分析
             如果把Java源程序想象成我们的C++源程序，Java源程序编译后生成的字节码就相当于C++源程序编译后的80x86的机器码（二进制程序文件），JVM虚拟机相当于80x86计算机系统，Java解释器相当于80x86CPU。在80x86CPU上运行的是机器码，在Java解释器上运行的是Java字节码。
             Java解释器相当于运行Java字节码的“CPU”，但该“CPU”不是通过硬件实现的，而是用软件实现的。Java解释器实际上就是特定的平台下的一个应用程序。只要实现了特定平台下的解释器程序，Java字节码就能通过解释器程序在该平台下运行，这是Java跨平台的根本。当前，并不是在所有的平台下都有相应Java解释器程序，这也是Java并不能在所有的平台下都能运行的原因，它只能在已实现了Java解释器程序的平台下运行。




javac就是Java编译器
java就是Java解释器



D:\workspace\Java>cd lesson1

D:\workspace\Java\lesson1>dir
 驱动器 D 中的卷是 LOCAL
 卷的序列号是 CB30-2D7F

 D:\workspace\Java\lesson1 的目录

2006-12-17  19:49    <DIR>          .
2006-12-17  19:49    <DIR>          ..
2006-12-17  19:50                 7 hello.java.bak
2006-12-17  19:53                20 hello.java
               2 个文件             27 字节
               2 个目录  1,304,494,080 可用字节

D:\workspace\Java\lesson1>javac hello.java

D:\workspace\Java\lesson1>dir
 驱动器 D 中的卷是 LOCAL
 卷的序列号是 CB30-2D7F

 D:\workspace\Java\lesson1 的目录

2006-12-17  19:49    <DIR>          .
2006-12-17  19:49    <DIR>          ..
2006-12-17  19:50                 7 hello.java.bak
2006-12-17  19:53                20 hello.java
2006-12-17  19:54               184 hello.class
               3 个文件            211 字节
               2 个目录  1,304,477,696 可用字节

D:\workspace\Java\lesson1>java hello.class
Exception in thread "main" java.lang.NoClassDefFoundError: hello/class

D:\workspace\Java\lesson1>

配置环境变量:
依次"我的电脑->属性->高级->环境变量(N)->变量"在这里有个path变量,
它就是可执行程序的环境路径,
可以在命令提示符下输入:path查看系统的path环境变量
D:\workspace\Java\lesson1>path
PATH=M:\WINDOWS\system32;M:\WINDOWS;M:\WINDOWS\System32\Wbem;M:\Program Files\Mi
crosoft Visual Studio\Common\Tools\WinNT;M:\Program Files\Microsoft Visual Studi
o\Common\MSDev98\Bin;M:\Program Files\Microsoft Visual Studio\Common\Tools;c:\Pr
ogram Files\Visual Studio\VC98\bin;C:\Program Files\Java\jdk1.5.0_08\bin


在同一个文件中可以编写多个类,
在编译的时候,为每个类单独生成一个*.class的类文件,
这在开发大型程序时,会产生很多类文件,这样就不太方便了.
为此,sun公司提供 jar.exe 打包工具,它可以将很多类文件打包成一个jar包,
这种jar包可以通过winrar工具打开,

D:\workspace\Java\lesson1>jar
用法：jar {ctxu}[vfm0Mi] [jar-文件] [manifest-文件] [-C 目录] 文件名 ...
选项：
    -c  创建新的存档
    -t  列出存档内容的列表
    -x  展开存档中的命名的（或所有的〕文件
    -u  更新已存在的存档
    -v  生成详细输出到标准输出上
    -f  指定存档文件名
    -m  包含来自标明文件的标明信息
    -0  只存储方式；未用ZIP压缩格式
    -M  不产生所有项的清单（manifest〕文件
    -i  为指定的jar文件产生索引信息
    -C  改变到指定的目录，并且包含下列文件：
如果一个文件名是一个目录，它将被递归处理。
清单（manifest〕文件名和存档文件名都需要被指定，按'm' 和 'f'标志指定的相同顺序。

示例1：将两个class文件存档到一个名为 'classes.jar' 的存档文件中：
       jar cvf classes.jar Foo.class Bar.class
示例2：用一个存在的清单（manifest）文件 'mymanifest' 将 foo/ 目录下的所有
           文件存档到一个名为 'classes.jar' 的存档文件中：
       jar cvfm classes.jar mymanifest -C foo/ .


D:\workspace\Java\lesson1>jar cvf Lesson1.jar hello.class Welcome.class
标明清单(manifest)
增加：hello.class(读入= 184) (写出= 155)(压缩了 15%)
增加：Welcome.class(读入= 186) (写出= 157)(压缩了 15%)

D:\workspace\Java\lesson1>dir
 驱动器 D 中的卷是 LOCAL
 卷的序列号是 CB30-2D7F

 D:\workspace\Java\lesson1 的目录

2006-12-17  19:49    <DIR>          .
2006-12-17  19:49    <DIR>          ..
2006-12-17  20:04               184 hello.class
2006-12-17  20:03                20 hello.java.bak
2006-12-17  20:04                46 hello.java
2006-12-17  20:04               186 Welcome.class
2006-12-17  20:10               889 Lesson1.jar
               5 个文件          1,325 字节
               2 个目录  1,304,428,544 可用字节

D:\workspace\Java\lesson1>cd .

D:\workspace\Java\lesson1>cd ..

D:\workspace\Java>jar cvf Lesson1.jar lesson1
标明清单(manifest)
增加：lesson1/(读入= 0) (写出= 0)(存储了 0%)
增加：lesson1/hello.class(读入= 184) (写出= 155)(压缩了 15%)
增加：lesson1/hello.java.bak(读入= 20) (写出= 22)(压缩了 -10%)
增加：lesson1/hello.java(读入= 46) (写出= 37)(压缩了 19%)
增加：lesson1/Welcome.class(读入= 186) (写出= 157)(压缩了 15%)
增加：lesson1/Lesson1.jar(读入= 889) (写出= 475)(压缩了 46%)


{
	hello.java:

	class Hello
	{

	}

	public class Welcome
	{

	}


	D:\workspace\Java\lesson1>javac hello.java
	hello.java:6: 类 Welcome 是公共的，应在名为 Welcome.java 的文件中声明
	public class Welcome
	       ^
	1 错误

	这里可以看到,包含有声明为public的类的文件,文件名称要被命名为该类的类名.
	每个文件里只能有一个声明为public的类,
	好的现在将文件名该为 Welcome.java文件内容修改如下:
	public class Welcome
	{
		/*public static void main( String[] args )
		{
		}
		*/
	}

	D:\workspace\Java\lesson1>javac Welcome.java

	D:\workspace\Java\lesson1>java Welcome.class
	Exception in thread "main" java.lang.NoClassDefFoundError: Welcome/class

		编译后运行时就提示没有mian方法,这就好像C/C++中一样,必须要有main函数.

		现在修改源文件如下：

	public class Welcome
	{
		public static void main( String[] args )
		{
			System.out.print("Hello world!\n");
			System.out.println("http://blog.csdn.net/zieckey");
		}
	}


	D:\workspace\Java\lesson1>javac Welcome.java

	D:\workspace\Java\lesson1>java Welcome.class
	Exception in thread "main" java.lang.NoClassDefFoundError: Welcome/class

	D:\workspace\Java\lesson1>java Welcome
	Hello world!
	http://blog.csdn.net/zieckey

	可以看到运行结果。
	这里还可以看到，运行时不是 java Welcome.class，而是java Welcome
}


Java基本数据类型
{
	public class Welcome
	{
		public static void main( String[] args )
		{
			/*
			System.out.print("Hello world!\n");
			System.out.println("http://blog.csdn.net/zieckey");
			*/
			/*
			java提供了8种数据类型
			byte 	b;
			int  	i;
			long	l;
			char   	ch;
			float 	f;
			double  d;
			boolean bool;
			*/
			byte b;//这里b是一个8位的数，可以表示：-128~127之间的任何数。
			b = 5;
			b = b*3 ;
			println( b );//这里的println可以自动识别输出变量的格式。
		}
	}

	D:\workspace\Java\lesson1>javac Welcome.java
	Welcome.java:21: 可能损失精度
	找到： int
	需要： byte
	                b = b*3 ;
	                     ^
	Welcome.java:22: 找不到符号
	符号： 方法 println(byte)
	位置： 类 Welcome
	                println( b );//这里的println可以自动识别输出变量的格式。
	                ^
	2 错误

	这里是因为，byte类型在参入运算时，为了保证精度转换为int类型，
	这个错误在C/C++中往往是一个警告，而这里就是错误，这是java的安全机制一个体现

	下面修改一下源文件：
	将
	b = b*3 ;
	改为：
	b = (byte)b*3 ;
	再去编译下,可以发现,出现同样的错误.

	public class Welcome
	{
		public static void main( String[] args )
		{
			/*
			System.out.print("Hello world!\n");
			System.out.println("http://blog.csdn.net/zieckey");
			*/
			/*
			java提供了8种数据类型
			byte 	b;//这里b是一个8位的数，可以表示：-128~127之间的任何数。
			short 	s;//2字节的有符号的整数.可以表示：-32768~32767之间的任何数。
			int  	i;//4字节的有符号的整数
			long	l;//8字节的有符号的整数
			char   	c;//2个字节的无符号整数,可以表示：0~65535之间的任何数。
			float 	f;//4字节的
			double  d;//8字节的
			boolean bool;//只能用 true 和 false
			*/
			byte b;//这里b是一个8位的数，可以表示：-128~127之间的任何数。
			b = 5;
			b = (byte)( b * 3 ) ;
			System.out.println( b ); //这里的println可以自动识别输出变量的格式。
		}
	}

	编译运行:
	D:\workspace\Java\lesson1>javac Welcome.java

	D:\workspace\Java\lesson1>java Welcome
	15

	D:\workspace\Java\lesson1>

	给float变量这样赋值时:
	float f = 1.3;
	编译会报错:

	D:\workspace\Java\lesson1>javac Welcome.java
	Welcome.java:38: 可能损失精度
	找到： double
	需要： float
	                float f = 1.3;
	                          ^
	1 错误

	在Java中小数的常量被认为是一个double类型,
	所以应该这样给float变量赋值.
	float f = 1.3f;

	给boolean变量赋值时只能取两个值:
	 bool = true;或者 bool = false;

	D:\workspace\Java\lesson1>javac Welcome.java
	D:\workspace\Java\lesson1>java Welcome
	true

	在做条件判断的时候,也只能用 true 和 false
	if ( 1 )
	{
	}
	这样的写法会出错的.

	D:\workspace\Java\lesson1>javac Welcome.java
	Welcome.java:45: 不兼容的类型
	找到： int
	需要： boolean
	                if ( 1 )
	                     ^
	1 错误
}

Java数组 :
{
	如果想在C/C++中那样定义的: int num[5];
	int num[5];//这里不能预先写出数组的空间大小。

	int num[];	//OK
	num = new int[5];  //先定义，后分配空间。

	//在Java中推荐使用 int[] num;	这种方式定义数组，这样就直白明了，
	//是定义了一个int类型的数组 num ，
	//如果int num[];那么到底num是变量呢还num[]是变量？
	int[] num;	//int [] num;	int []num;	//[]的位置没有关系
	num = new int[5];  //先定义，后分配空间。

	//可以在定义的时候初始化
	int []num={1,2,3};//OK

	//或者
	int []num2 = new int[]{1,2,3};//OK
	但是不能指定空间大小
	//int []num3 = new int[3]{1,2,3};//ERROR

	对数组的赋值:
	{
		int [] num3;
		num3 = new int[3];
		num3[0] = 1;
		num3[1] = 12;
		num3[2] = 13;

		System.out.println( num3[0] );
		System.out.println( num3[1] );
		System.out.println( num3[2] );
	}


	二维数组:
	/* OK
	int [][] a;
	a = new int [3][4];//3行4列
	a[0][1] = 12;
	a[2][3] = 14;
	*/

	对于二维数组,Java中每行的列数可以不相等,这就和C/C++中的指针数组较为相像
	这对于存储字符串比较方便。

	二维数组初始化
	{
		//int [][] c = new int [][]{1,2,3,4,5,6};//ERROR
		//int [][] c = new int [2][]{{1,2,3},{4,5,6}};//Error
		int [][] c = new int [][]{{1,2,3},{4,5,6}};//OK
		int [][] d = {{1,2,3},{4,5,6}};//OK
		int [][] e = {{1,2,3},{4,5},{6}};//OK

		System.out.println( e[0][2] );
		System.out.println( e[0][1] );
		System.out.println( e[0][0] );
		System.out.println( e[1][1] );
		System.out.println( e[1][0] );
		System.out.println( e[2][0] );
	}

	++ 和 -- 操作符同C/C++中是一样的。
	{
		/*
		int i =3 ;
		int count;
		count = (i++) + (i++) + (i++);
		System.out.println( i );  //输出6
		*/
		/*
		int i =3 ;
		int count;
		count = (++i) + (++i) + (++i);
		System.out.println( i );  //输出6
		System.out.println( count );//输出15
		*/
	}

	过程语句
	/*
		if(true)
		{
		}

		while(true)
		{
		}

		do
		{
		}while(true);

		for(int i=0;i<10;i++)
		{
		}

		*/
}



Lesson2
位操作
{
	class Test
	{
		public static void main(String args[])
		{
			int i = 0xffffffff;
			int c = i<<2; //带符号左移
			System.out.println(i);
			System.out.println(Integer.toHexString(c));//将c代表的数以16进制形式输出fffffffc

			c = i>>2;//带符号右移
			System.out.println(Integer.toHexString(c));//将c代表的数以16进制形式输出ffffffff
			c = i>>>2;//不带符号右移
			System.out.println(Integer.toHexString(c));//将c代表的数以16进制形式输出3fffffff

		}
	}
}

面向对象编程方法：
{
	//Point.java
	class Point
	{
		int x,y;
		void output()
		{
			System.out.println(x);
			System.out.println(y);
		}
		public static void main(String args[])
		{
			Point pt;
			pt = new Point();
			Point.x = 20;
			Point.y = 20;
			pt.output();
		}
	}

	这个程序在编译时出现错误：
	E:\study\JAVA\Java-Study\JavaLesson\Lesson2\temp>javac Point.java
	Point.java:13: 无法从静态上下文中引用非静态 变量 x
	                Point.x = 20;
	                     ^
	Point.java:14: 无法从静态上下文中引用非静态 变量 y
	                Point.y = 20;
	                     ^
	2 错误
	修改程序：

	//Point.java
	class Point
	{
		static int x,y; //注意这里的改变
		void output()
		{
			System.out.println(x);
			System.out.println(y);
		}
		public static void main(String args[])
		{
			Point pt;
			pt = new Point();
			Point.x = 20;
			Point.y = 20;
			pt.output();
		}
	}
	这样就不会出错

}





2006/12/20
Lesson3

为了便于管理大型软件系统中数目众多的类，解决类命名冲突的问题，Java引入了包（package）。

//Test.java
package zieckey;
class Test
{
	public static void main( String[] args )
	{
		System.out.println( "zieckey test!");
	}
}

E:\study\JAVA\Java-Study\JavaLesson\Lesson3>javac Test.java

E:\study\JAVA\Java-Study\JavaLesson\Lesson3>java Test
Exception in thread "main" java.lang.NoClassDefFoundError: Test (wrong name: zieckey/Test)
        at java.lang.ClassLoader.defineClass1(Native Method)
        at java.lang.ClassLoader.defineClass(Unknown Source)
        at java.security.SecureClassLoader.defineClass(Unknown Source)
        at java.net.URLClassLoader.defineClass(Unknown Source)
        at java.net.URLClassLoader.access$100(Unknown Source)
        at java.net.URLClassLoader$1.run(Unknown Source)
        at java.security.AccessController.doPrivileged(Native Method)
        at java.net.URLClassLoader.findClass(Unknown Source)
        at java.lang.ClassLoader.loadClass(Unknown Source)
        at sun.misc.Launcher$AppClassLoader.loadClass(Unknown Source)
        at java.lang.ClassLoader.loadClass(Unknown Source)
        at java.lang.ClassLoader.loadClassInternal(Unknown Source)
这样直接运行会出错，我们必须带上包名：

E:\study\JAVA\Java-Study\JavaLesson\Lesson3>java zieckey.Test
Exception in thread "main" java.lang.NoClassDefFoundError: zieckey/Test

这样还是会出错，实际上，包就像我们的文件系统一样，我们现在在当前目录下，
新建一个以包名“zieckey”命名的文件夹，然后将Test.class放到该“zieckey”命名的文件夹中。

E:\study\JAVA\Java-Study\JavaLesson\Lesson3>mkdir zieckey

E:\study\JAVA\Java-Study\JavaLesson\Lesson3>copy Test.class zieckey
已复制         1 个文件。

E:\study\JAVA\Java-Study\JavaLesson\Lesson3>java zieckey.Test
zieckey test!

或者
E:\study\JAVA\Java-Study\JavaLesson\Lesson3>java zieckey/Test
zieckey test!

好了，现在就成功了。

我们还可以给包名加上限定名：
package cn.zieckey;
class Test
{
	public static void main( String[] args )
	{
		System.out.println( "zieckey test!");
	}
}
编译运行：

E:\study\JAVA\Java-Study\JavaLesson\Lesson3>javac Test.java

E:\study\JAVA\Java-Study\JavaLesson\Lesson3>copy Test.class zieckey
改写 zieckey\Test.class 吗? (Yes/No/All): y
已复制         1 个文件。

E:\study\JAVA\Java-Study\JavaLesson\Lesson3>java zieckey.Test
Exception in thread "main" java.lang.NoClassDefFoundError: zieckey/Test (wrong n
ame: cn/zieckey/Test)
        at java.lang.ClassLoader.defineClass1(Native Method)
        at java.lang.ClassLoader.defineClass(Unknown Source)
        at java.security.SecureClassLoader.defineClass(Unknown Source)
        at java.net.URLClassLoader.defineClass(Unknown Source)
        at java.net.URLClassLoader.access$100(Unknown Source)
        at java.net.URLClassLoader$1.run(Unknown Source)
        at java.security.AccessController.doPrivileged(Native Method)
        at java.net.URLClassLoader.findClass(Unknown Source)
        at java.lang.ClassLoader.loadClass(Unknown Source)
        at sun.misc.Launcher$AppClassLoader.loadClass(Unknown Source)
        at java.lang.ClassLoader.loadClass(Unknown Source)
        at java.lang.ClassLoader.loadClassInternal(Unknown Source)

我们发现有出现了问题，其实一样的，我们只需要再将 zieckey 文件夹放到 cn 文件夹下：
E:\study\JAVA\Java-Study\JavaLesson\Lesson3>java cn.zieckey.Test
zieckey test!

package语句必须是文件中的第一条语句。
也就是说，在package语句之前，除了空白和注释之外不能有任何语句。
如果不加package语句，则指定为缺省包或无名包。
包对应着文件系统的目录层次结构。
在package语句中，用“.”来指明包（目录）的层次。

我们如果每次都要手动的添加包对应的文件夹，那将是一件不那么愉快的事情，
幸好Java编译器为我们准备了这样的方法，省去我们自己手动添加包对应的文件夹。


E:\study\JAVA\Java-Study\JavaLesson\Lesson3>javac
用法：javac <选项> <源文件>
其中，可能的选项包括：
  -g                         生成所有调试信息
  -g:none                    不生成任何调试信息
  -g:{lines,vars,source}     只生成某些调试信息
  -nowarn                    不生成任何警告
  -verbose                   输出有关编译器正在执行的操作的消息
  -deprecation               输出使用已过时的 API 的源位置
  -classpath <路径>            指定查找用户类文件的位置
  -cp <路径>                   指定查找用户类文件的位置
  -sourcepath <路径>           指定查找输入源文件的位置
  -bootclasspath <路径>        覆盖引导类文件的位置
  -extdirs <目录>              覆盖安装的扩展目录的位置
  -endorseddirs <目录>         覆盖签名的标准路径的位置
  -d <目录>                    指定存放生成的类文件的位置
  -encoding <编码>             指定源文件使用的字符编码
  -source <版本>               提供与指定版本的源兼容性
  -target <版本>               生成特定 VM 版本的类文件
  -version                   版本信息
  -help                      输出标准选项的提要
  -X                         输出非标准选项的提要
  -J<标志>                     直接将 <标志> 传递给运行时系统

-d 参数可以帮助我们自动生成包对应的文件夹，并把类放到相应的文件夹下。
E:\study\JAVA\Java-Study\JavaLesson\Lesson3>javac -d . Test.java

E:\study\JAVA\Java-Study\JavaLesson\Lesson3>java cn/zieckey/Test
zieckey test!

编译并生成包
在当前目录下生成包
    javac –d . Test.java
在指定目录下生成包
    javac –d E:\JavaLesson Test.java

E:\study\JAVA\Java-Study\JavaLesson\Lesson3>javac -d d:\ Test.java

E:\study\JAVA\Java-Study\JavaLesson\Lesson3>set classpath=%classpath%;d:\

E:\study\JAVA\Java-Study\JavaLesson\Lesson3>java cn/zieckey/Test
zieckey test!


包中类的实例对象的声明：
package cn.zieckey;
class Test
{
	public static void main( String[] args )
	{
		Test t = new Test();//在这个包所在源文件中可以直接用类名
		cn.zieckey.Test tt = new cn.zieckey.Test();//也可以用完整名称
		System.out.println( "zieckey test!");
	}
}


import语句
引入包中的类。
    import java.io.File;
引入整个包。
    import java.io.*;
在同一包中的类可以互相引用，无需import语句。

注意：java.lang包中的类是自动导入的，所以我们引用该包中类可以不用import语句导入。

当引用其它包中的类：
package cn.zieckey;
class Test
{
	public static void main( String[] args )
	{
		Test t = new Test();//在这个包所在源文件中可以直接用类名
		cn.zieckey.Test tt = new cn.zieckey.Test();//也可以用完整名称
		java.io.File f ;//用完整名称引用类
		System.out.println( "zieckey test!");
	}
}

或者：
package cn.zieckey;
import java.io.File;
class Test
{
	public static void main( String[] args )
	{
		Test t = new Test();//在这个包所在源文件中可以直接用类名
		cn.zieckey.Test tt = new cn.zieckey.Test();//也可以用完整名称
		File f ;//如果提前导入了这个包，就可以直接用类名称引用类
		System.out.println( "zieckey test!");
	}
}

我们也可以直接通过导入所有包，以省事:import java.io.*;
但是我们这样的话,会需要更多的内存,这对于pc来说没有什么,但是对于手持式嵌入式设备,就不那么好了.

我们在同一个包中再新建一个类:
//Test2.java
package cn.zieckey;
class Test2
{
}

然后我们在Test类中可以直接引用Test2
//Test.java
package cn.zieckey;
import java.io.File;
class Test
{
	public static void main( String[] args )
	{
		/*
		Test t = new Test();//在这个包所在源文件中可以直接用类名
		cn.zieckey.Test tt = new cn.zieckey.Test();//也可以用完整名称
		File f ;//如果提前导入了这个包，就可以直接用类名称引用类
		System.out.println( "zieckey test!");
		*/
		Test2 t2 = new Test2();
	}
}

E:\JavaLesson\Lesson3>javac -d . *.java
编译没有问题
如果我们的Test2.java文件是这样写的:
//Test2.java
//package cn.zieckey;
package com.zieckey;
class Test2
{
}
E:\JavaLesson\Lesson3>javac -d . *.java
Test.java:14: 找不到符号
符号： 类 Test2
位置： 类 cn.zieckey.Test
                Test2 t2 = new Test2();
                ^
Test.java:14: 找不到符号
符号： 类 Test2
位置： 类 cn.zieckey.Test
                Test2 t2 = new Test2();
                               ^
2 错误
编译就有错误,那么我们只能通过在Test.java中导入Test2这个类.
//Test.java
package cn.zieckey;
import com.zieckey.Test2;
class Test
{
	public static void main( String[] args )
	{
		Test2 t2 = new Test2();
	}
}
但是编译还是出现问题:
E:\JavaLesson\Lesson3>javac -d . *.java
Test.java:4: com.zieckey.Test2 在 com.zieckey 中不是公共的；无法从外部软件包中对
其进行访问
import com.zieckey.Test2;
                   ^
Test.java:15: 找不到符号
符号： 类 Test2
位置： 类 cn.zieckey.Test
                Test2 t2 = new Test2();
                ^
Test.java:15: 找不到符号
符号： 类 Test2
位置： 类 cn.zieckey.Test
                Test2 t2 = new Test2();
                               ^
3 错误

这里是说 com.zieckey.Test2 在 com.zieckey 中不是公共的；无法从外部软件包中对
其进行访问,所以应该把 com.zieckey.Test2 改为共有的.
//Test2.java
//package cn.zieckey;
package com.zieckey;
public class Test2
{
}
再编译就没有问题了.
E:\JavaLesson\Lesson3>javac -d . *.java

我们把一个类声明为共有的就是让它能不所有的类调用,如果不声明为共有,
那么它就是缺省的类,就只能被同一个包中的类调用.

类的访问说明符
 （1）public
 （2）default（不加访问说明符时）
类的其它修饰符
 （1）final,用它定义的类就不能被继承.
 （2）abstract


（1）final,用它定义的类就不能被继承.
//Test2.java
package com.zieckey;
public final class Test2
{
}

//Test.java
package cn.zieckey;
class Test //extends com.zieckey.Test2
{
	public static void main( String[] args )
	{
		com.zieckey.Test2 t2 = new com.zieckey.Test2();
	}
}

E:\JavaLesson\Lesson3>javac -d . *.java
Test.java:3: 无法从最终 com.zieckey.Test2 进行继承
class Test extends com.zieckey.Test2
                              ^
1 错误


方法的访问说明符
 （1）public
 （2）protected
 （3）default(不加访问说明符时)
 （4）private
方法的其它修饰符
 （1）static
 （2）final
 （3）abstract
 （4）native
 （5）synchronized


测试类的方法的访问权限问题:
//Test.java
package cn.zieckey;
public class Test
{
	public void publicMethod()
	{
		System.out.println( "publicMethod!" );
	}
	protected void protectedMethod()
	{
		System.out.println( "protectedMethod!" );
	}
	void defaultMethod()
	{
		System.out.println( "defaultMethod!" );
	}
	private void privateMethod()
	{
		System.out.println( "privateMethod!" );
	}

	public static void main( String[] args )
	{
		Test t = new Test();
		t.publicMethod();
		t.protectedMethod();
		t.defaultMethod();
		t.privateMethod();
	}
}

E:\JavaLesson\Lesson3>javac -d . Test.java

E:\JavaLesson\Lesson3>java cn.zieckey.Test
publicMethod!
protectedMethod!
defaultMethod!
privateMethod!

这说明在同一类中public,protected,default,private四类都可以访问.
现在将Test2.java改为：
//Test2.java
package cn.zieckey;
public final class Test2
{
	public static void main( String[] args )
	{
		Test t = new Test();
		t.publicMethod();
		t.protectedMethod();
		t.defaultMethod();
		t.privateMethod();
	}
}
E:\JavaLesson\Lesson3>javac -d . Test2.java
Test2.java:11: privateMethod() 可以在 cn.zieckey.Test 中访问 private
                t.privateMethod();
                 ^
1 错误

好的，就不测试那么多了，总结下：

			方法的访问控制：
		public  	protected		default		private
同类	是			是				是			是
同包	是			是				是
子类	是			是
通用性	是

final方法：
为了确保某个函数的行为在继承过程中保持不变，并且不能被覆盖（overridden），可以使用final方法。
为了效率上的考虑，将方法声明为final，让编译器对此方法的调用进行优化。要注意的是：编译器会自行对final方法进行判断，并决定是否进行优化。通常在方法的体积很小，而我们确实不希望它被覆盖时，才将它声明为final。
class中所有的private和static方法自然就是final。

抽象方法和抽象类
在类中没有方法体的方法，就是抽象方法。
含有抽象方法的类，即为抽象类。
如果一个子类没有实现抽象基类中所有的抽象方法，则子类也成为一个抽象类。
我们可以将一个没有任何抽象方法的类声明为abstract，避免由这个类产生任何的对象。
构造方法、静态方法、私有方法、final方法不能被声明为抽象的方法。
例子:
//Test.java
package cn.zieckey;
public class Test
{
	public final void publicMethod()
	{
		System.out.println( "publicMethod!" );
	}
	protected abstract void protectedMethod();
	/*{
		System.out.println( "protectedMethod!" );
	}*/
	void defaultMethod()
	{
		System.out.println( "defaultMethod!" );
	}
	private void privateMethod()
	{
		System.out.println( "privateMethod!" );
	}

	public static void main( String[] args )
	{
		Test t = new Test();
		t.publicMethod();
		t.protectedMethod();
		t.defaultMethod();
		t.privateMethod();
	}
}

E:\JavaLesson\Lesson3>javac -d . Test.java
Test.java:3: cn.zieckey.Test 不是抽象的，并且未覆盖 cn.zieckey.Test 中的抽象方法
 protectedMethod()
public class Test
       ^
1 错误

就是说方法是抽象的,但是拥有该方法的类并不是抽象的.
编译就有错误。
//Test.java
package cn.zieckey;
public abstract class Test
{
	public final void publicMethod()
	{
		System.out.println( "publicMethod!" );
	}
	protected abstract void protectedMethod();
	/*{
		System.out.println( "protectedMethod!" );
	}*/
	void defaultMethod()
	{
		System.out.println( "defaultMethod!" );
	}
	private void privateMethod()
	{
		System.out.println( "privateMethod!" );
	}

	public static void main( String[] args )
	{
		Test t = new Test();
		t.publicMethod();
		t.protectedMethod();
		t.defaultMethod();
		t.privateMethod();
	}
}
E:\JavaLesson\Lesson3>javac -d . Test.java
Test.java:24: cn.zieckey.Test 是抽象的；无法对其进行实例化
                Test t = new Test();
                         ^
1 错误
再修改:
//Test.java
package cn.zieckey;
public abstract class Test
{
	public final void publicMethod()
	{
		System.out.println( "publicMethod!" );
	}
	protected abstract void protectedMethod();
	/*{
		System.out.println( "protectedMethod!" );
	}*/
	void defaultMethod()
	{
		System.out.println( "defaultMethod!" );
	}
	private void privateMethod()
	{
		System.out.println( "privateMethod!" );
	}

	public static void main( String[] args )
	{
		/*Test t = new Test();
		t.publicMethod();
		t.protectedMethod();
		t.defaultMethod();
		t.privateMethod();*/
	}
}

E:\JavaLesson\Lesson3>javac -d . Test.java
这样编译就没有问题了.
总结：所以如果方法是抽象的，那么相应的类也要是抽象的，并且抽象的类不能实例化。

现在让Test2继承自Test
//Test2.java
package cn.zieckey;
import cn.zieckey.Test;
public class Test2 extends Test
{

	public static void main( String[] args )
	{
	}
}
E:\JavaLesson\Lesson3>javac -d . Test2.java
Test2.java:4: cn.zieckey.Test2 不是抽象的，并且未覆盖 cn.zieckey.Test 中的抽象方
法 protectedMethod()
public class Test2 extends Test
       ^
1 错误

再修改,将上面的抽象方法具体化:
//Test2.java
package cn.zieckey;
import cn.zieckey.Test;
public class Test2 extends Test
{
	protected void protectedMethod()
	{
	}
	public static void main( String[] args )
	{
	}
}
E:\JavaLesson\Lesson3>javac -d . Test2.java
编译没有错误了。

但是如果我们再将Test2.java改为如下：
//Test2.java
package cn.zieckey;
import cn.zieckey.Test;
public abstract class Test2 extends Test
{
	/*protected void protectedMethod()
	{
	}*/
	public static void main( String[] args )
	{
	}
}
E:\JavaLesson\Lesson3>javac -d . Test2.java

E:\JavaLesson\Lesson3>
这样我们将子类也声明为抽象的方法，编译也就没有错误了。

总结：抽象的类被继承时，要么子类也声明为抽象类，要么在子类中实现父类的抽象方法.


native方法
{
	native方法是用户在Java中可以使用，但不能编写的方法。
	JNI(Java Native Interface)，它允许Java虚拟机(JVM)内部运行的Java代码能够
与用其它编程语言(如C、C++、汇编语言)编写的应用程序和库进行互操作。
	JNI最大的好处是它没有对底层Java虚拟机的实现施加任何限制,
因此，Java虚拟机厂商可以在不影响虚拟机其它部分的情况下添加对JNI的支持。
程序员只需编写一种版本的本地(Native)应用程序和库，
就能够与所有支持JNI的Java虚拟机协同工作。
	JNI可以理解为Java和本地应用程序之间的中介。


创建一个native方法：
1. 创建一个HelloWorld.java
class HelloWorld
{
    public native void displayHelloWorld();

    static
    {
        System.loadLibrary("hello");
    }

    public static void main(String[] args) {
        new HelloWorld().displayHelloWorld();
    }
}

2. 编译
E:\zieckey\Lesson3>javac HelloWorld.java

3. 生成头文件
E:\zieckey\Lesson3>javah -jni HelloWorld

4. 写实现文件HelloWorldImp.c
#include <jni.h>
#include "HelloWorld.h"
#include <stdio.h>

JNIEXPORT void JNICALL
Java_HelloWorld_displayHelloWorld(JNIEnv *env, jobject obj)
{
    printf("Hello world!\n");
    return;
}

5. 生成动态连接库
这里运用VC的CL.exe工具，
或者直接在VC下建立工程来生成（这里注意将D:\Program Files\Java\jdk1.5.0_06\include，
D:\Program Files\Java\jdk1.5.0_06\include\win32这两个目录加入环境中）
E:\zieckey\Lesson3>cl -ID:\Program Files\Java\jdk1.5.0_06\include -ID:\Program Files\Java\jdk1.5.0_06\include\win32 -LDHelloWorldImp.c -Fhello.dll

6. 执行
E:\zieckey\Lesson3>java HelloWorld







JNI

最近在公司里做了一个手机的项目，需要JAVA程序在发送短信的时候和第三方的短信服务器连接。短信接口是用C++写的。琢磨了三天，大致搞懂了JNI的主体部分。先将心得整理，希望各位朋友少走弯路。
首先引用一篇文章，介绍一个简单的JNI的调用的过程。
JAVA以其跨平台的特性深受人们喜爱，而又正由于它的跨平台的目的，使得它和本地机器的各种内部联系变得很少，约束了它的功能。解决JAVA对本地操作的一种方法就是JNI。
JAVA通过JNI调用本地方法，而本地方法是以库文件的形式存放的（在WINDOWS平台上是DLL文件形式，在UNIX机器上是SO文件形式）。通过调用本地的库文件的内部方法，使JAVA可以实现和本地机器的紧密联系，调用系统级的各接口方法。
简单介绍及应用如下：
一、JAVA中所需要做的工作
在JAVA程序中，首先需要在类中声明所调用的库名称，如下：
static {
System.loadLibrary(“goodluck”);
}

在这里，库的扩展名字可以不用写出来，究竟是DLL还是SO，由系统自己判断。
还需要对将要调用的方法做本地声明，关键字为native。并且只需要声明，而不需要具 体实现。如下：
public native static void set(int i);
public native static int get();
然后编译该JAVA程序文件，生成CLASS，再用JAVAH命令，JNI就会生成C/C++的头文件。
例如程序testdll.java，内容为：
public class testdll
{
static
{
System.loadLibrary("goodluck");
}
public native static int get();
public native static void set(int i);
public static void main(String[] args)
{
testdll test = new testdll();
test.set(10);
System.out.println(test.get());
}
}

用javac testdll.java编译它，会生成testdll.class。
再用javah testdll，则会在当前目录下生成testdll.h文件，这个文件需要被C/C++程序调用来生成所需的库文件。
二、C/C++中所需要做的工作
对于已生成的.h头文件，C/C++所需要做的，就是把它的各个方法具体的实现。然后编译连接成库文件即可。再把库文件拷贝到JAVA程序的路径下面，就可以用JAVA调用C/C++所实现的功能了。
接上例子。我们先看一下testdll.h文件的内容：
/* DO NOT ED99v THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class testdll */
#ifndef _Included_testdll
#define _Included_testdll
#ifdef __cplusplus
extern "C" {
#endif
/*
* Class: testdll
* Method: get
* Signature: ()I
*/
JNIEXPORT jint JNICALL Java_testdll_get (JNIEnv *, jclass);
/*
* Class: testdll
* Method: set
* Signature: (I)V
*/
JNIEXPORT void JNICALL Java_testdll_set (JNIEnv *, jclass, jint);
#ifdef __cplusplus
}
#endif
#endif
在具体实现的时候，我们只关心两个函数原型
JNIEXPORT jint JNICALL Java_testdll_get (JNIEnv *, jclass); 和
JNIEXPORT void JNICALL Java_testdll_set (JNIEnv *, jclass, jint);
这里JNIEXPORT和JNICALL都是JNI的关键字，表示此函数是要被JNI调用的。而jint是以JNI为中介使JAVA的int类型与本地的 int沟通的一种类型，我们可以视而不见，就当做int使用。函数的名称是JAVA_再加上java程序的package路径再加函数名组成的。参数中，我们也只需要关心在JAVA程序中存在的参数，至于JNIEnv*和jclass我们一般没有必要去碰它。
好，下面我们用testdll.cpp文件具体实现这两个函数：
#include "testdll.h"
int i = 0;
JNIEXPORT jint JNICALL Java_testdll_get (JNIEnv *, jclass)
{
return i;
}
JNIEXPORT void JNICALL Java_testdll_set (JNIEnv *, jclass, jint j)
{
i = j;
}
编译连接成库文件，本例是在WINDOWS下做的，生成的是DLL文件。并且名称要与JAVA中需要调用的一致，这里就是goodluck.dll 。把goodluck.dll拷贝到testdll.class的目录下，java testdll运行它，就可以观察到结果了。  











垃圾回收：
//Garbage.java
class Garbage
{
	int index;
	static int count;
	Garbage()
	{
		count++;
		System.out.println( "object " + count + " constructed" );
		setID( count );
	}
	void setID( int id )
	{
		index = id;
	}
	protected void finalize()
	{
		System.out.println( "object " + index + " is reclaimed");
	}

	public static void main( String[] args )
	{
		new Garbage();
		new Garbage();
		new Garbage();
		new Garbage();
	}
}
看看上面程序运行看看：

E:\zieckey\Lesson3>javac Garbage.java

E:\zieckey\Lesson3>java Garbage
object 1 constructed
object 2 constructed
object 3 constructed
object 4 constructed
可以发现，这里并没有回收垃圾（回收垃圾会自动调用finalize方法），
这是因为，虚拟机是动态回收垃圾的，当系统内存不够用的时候才进行垃圾回收，
垃圾回收的线程的优先级很低。
我们可以显示的调用垃圾回收器回收垃圾：
//Garbage.java
class Garbage
{
	int index;
	static int count;
	Garbage()
	{
		count++;
		System.out.println( "object " + count + " constructed" );
		setID( count );
	}
	void setID( int id )
	{
		index = id;
	}
	protected void finalize()
	{
		System.out.println( "object " + index + " is reclaimed");
	}

	public static void main( String[] args )
	{
		new Garbage();
		new Garbage();
		new Garbage();
		new Garbage();
		System.gc();//显示的调用垃圾回收器回收垃圾
	}
}
E:\zieckey\Lesson3>javac Garbage.java

E:\zieckey\Lesson3>java Garbage
object 1 constructed
object 2 constructed
object 3 constructed
object 4 constructed
object 4 is reclaimed
object 3 is reclaimed
object 2 is reclaimed
object 1 is reclaimed


接口的调用：
接口中所有的方法都是public abstract。
在接口中声明方法时，不能使用native、static 、final 、synchronized 、private 、protected等修饰符。
和public类一样，public接口也必须定义在与接口同名的文件中。
接口中可以有数据成员，这些成员默认都是public static final。
一个接口可以继承自另一个接口。
Java中不允许类的多继承，但允许接口的多继承。
在Java中，一个类可以实现多个接口。
一个类在继承另外一个类的同时，可以实现多个接口。



//Sport.java
interface Sport
{
	void run();
	void jump();
}
class Athlete implements Sport
{
	void run()
	{
		System.out.println( "短跑" );
	}
	void jump()
	{
		System.out.println( "跳高" );
	}

	public static void main( String[] args )
	{
		Athlete zhangsan = new Athlete();
		zhangsan.run();
		zhangsan.jump();
	}
}

E:\zieckey\Lesson3>javac Sport.java
Sport.java:13: Athlete 中的 jump() 无法实现 Sport 中的 jump()；正在尝试指定更低
的访问权限；为 public
        void jump()
             ^
Sport.java:9: Athlete 中的 run() 无法实现 Sport 中的 run()；正在尝试指定更低的访
问权限；为 public
        void run()
             ^
2 错误

接口说明了，接口中所有的方法都是public abstract，
那么在实现中就不能比该访问权限更低，所以出现上面错误，
我们改改源文件看看：
//Sport.java
interface Sport
{
	public abstract void run();
	void jump();
}
class Athlete implements Sport
{
	public void run()
	{
		System.out.println( "短跑" );
	}
	void jump()
	{
		System.out.println( "跳高" );
	}

	public static void main( String[] args )
	{
		Athlete zhangsan = new Athlete();
		zhangsan.run();
		zhangsan.jump();
	}
}

E:\zieckey\Lesson3>javac Sport.java
Sport.java:13: Athlete 中的 jump() 无法实现 Sport 中的 jump()；正在尝试指定更低
的访问权限；为 public
        void jump()
             ^
1 错误


//Sport.java
interface Sport
{
	public abstract void run();
	void jump();
}
class Athlete implements Sport
{
	public void run()
	{
		System.out.println( "短跑" );
	}
	public void jump()
	{
		System.out.println( "跳高" );
	}

	public static void main( String[] args )
	{
		Athlete zhangsan = new Athlete();
		zhangsan.run();
		zhangsan.jump();
	}
}
E:\zieckey\Lesson3>javac Sport.java

E:\zieckey\Lesson3>java Athlete
短跑
跳高

E:\zieckey\Lesson3>

将实现中的方法访问权限改为接口的等同或者更高就可以了。
下面看看只实现接口中的一个方法：
//Sport.java
interface Sport
{
	public abstract void run();
	void jump();
}
class Athlete implements Sport
{
	public void run()
	{
		System.out.println( "短跑" );
	}
	/*public void jump()
	{
		System.out.println( "跳高" );
	}
	*/
	public static void main( String[] args )
	{
		Athlete zhangsan = new Athlete();
		zhangsan.run();
		zhangsan.jump();
	}
}
E:\zieckey\Lesson3>javac Sport.java
Sport.java:7: Athlete 不是抽象的，并且未覆盖 Sport 中的抽象方法 jump()
class Athlete implements Sport
^
Sport.java:22: 找不到符号
符号： 方法 jump()
位置： 类 Athlete
                zhangsan.jump();
                        ^
2 错误

这是因为接口中的所有方法都是public abstract，所以出现错误。

下面看看一个通过接口实现协同工作的例子：
现在我们需要在主板厂商和显卡厂商之间定义一个显卡插槽的接口，
然后根据这个标准接口，显卡厂商生产显卡，主板厂商生产主板。
程序实现如下：

显卡插槽接口：
//VideoCard.java
interface VideoCard
{
	void display();
	String getName();
}

显卡生产厂商生产显卡：
//Dmeng.java
class Dmeng implements VideoCard
{
	String name;
	Dmeng()
	{
		name = "Dmeng's VideoCard" ;
	}
	public void display()
	{
		System.out.println( "Dmeng's VideoCard is working!" );
	}
	public String getName()
	{
		return name;
	}
	public void setName( String name )
	{
		this.name = name;
	}
}

主板生产厂商生产主板
//MainBoard.java
class MainBoard
{
	String strCPU;
	VideoCard vc;
	MainBoard()
	{

	}
	void setCPU( String strCPU )
	{
		this.strCPU = strCPU;
	}

	//这里通过接口作为形参，在调用该方法的时候，
	//会传入一个实现该接口的类的实例对象
	void setVideoCard( VideoCard vc )
	{
		this.vc = vc ;
	}
	void run()
	{
		System.out.println( strCPU );
		System.out.println( vc.getName() );
		vc.display();
		System.out.println( "MainBoard is running..." );
	}
}

现在就可以组装电脑了
//Computer.java
class Computer
{
	public static void main( String[] args )
	{
		Dmeng d = new Dmeng();
		MainBoard m = new MainBoard();

		m.setCPU( "AMD's CPU" );
		m.setVideoCard( d );

		m.run();
	}
}

编译：
E:\zieckey\Lesson3\interface>javac *.java

E:\zieckey\Lesson3\interface>java Computer
AMD's CPU
Dmeng's VideoCard
Dmeng's VideoCard is working!
MainBoard is running...


再看一个例子：
//Math.java
interface Math
{
	double PI=3.1415926;
}
class Arithmetic implements Math
{
	double roundArea(double radius)
	{
		return PI*radius*radius;
	}
}
class Student
{
	public static void main(String[] args)
	{
		Arithmetic a=new Arithmetic();
		System.out.println(a.roundArea(3));
		System.out.println(Math.PI);		//ok
		System.out.println(Arithmetic.PI);	//ok
		System.out.println(a.PI);		//ok
	}
}



//Sofa.java
interface Sittable
{
	void sit();
}
interface Lie
{
	void sleep();
}
interface Chair extends Sittable
{
}

interface Sofa extends Sittable, Lie
{
}



//Sofa.java
//实现多个接口
interface Sittable
{
	void sit();
}
interface Lie
{
	void sleep();
}
class Sofa implements Sittable, Lie
{
	public void sit()
	{
	}
	public void sleep()
	{
	}
}


//Sofa.java
//在继承类的同时，实现多个接口
interface Sittable
{
	void sit();
}
interface Lie
{
	void sleep();
}
interface HealthCare
{
	void massage();
}
class Chair implements Sittable
{
	public void sit(){};
}
class Sofa extends Chair implements Lie, HealthCare
{
	public void sleep(){};
	public void massage(){};
}




内部类：
在方法中定义的内部类，如果要访问方法中定义的本地变量或方法的参数，则变量必须被声明final。
内部类可以声明为private或protected；还可以声明为abstract或final。
内部类可以声明为static的，但此时就不能再使用外部类的非static的成员变量和非static的成员方法；
非static的内部类中的成员不能声明为static的，只有在顶层类或static的内部类中才可声明static成员。

//Outer.java
class Outer
{
	private int index = 100;
	class Inner
	{
		private int index = 50;
		void print()
		{
			int index = 30;
			System.out.println( index );	//局部变量
			System.out.println( this.index );	//inner类变量
			System.out.println( Outer.this.index );	//Outer类变量
		}
	}
	void print()
	{
		Inner inner = new Inner();
		inner.print();
	}
}

class Test
{
	public static void main( String[] args )
	{
		Outer outer = new Outer();
		outer.print();
	}
}

编译：
E:\zieckey\Lesson4>javac Outer.java

E:\zieckey\Lesson4>java Test
30
50
100



访问内部类的方法：
//Outer.java
class Outer
{
	private int index = 100;
	class Inner
	{
		private int index = 50;
		void print()
		{
			int index = 30;
			System.out.println( index );	//局部变量
			System.out.println( this.index );	//inner类变量
			System.out.println( Outer.this.index );	//Outer类变量
		}
	}
	void print()
	{
		Inner inner = new Inner();
		inner.print();
	}

	Inner getInner() //提供访问内部类的方法
	{
		return new Inner();
	}
}

class Test
{
	public static void main( String[] args )
	{
		Outer outer = new Outer();
		//outer.print();
		Outer.Inner inner = outer.getInner();//这里通过Outer.Inner达到访问内部类
		inner.print();
	}
}

如果main方法在Outer类中：
//Outer.java
class Outer
{
	private int index = 100;
	class Inner
	{
		private int index = 50;
		void print()
		{
			int index = 30;
			System.out.println( index );	//局部变量
			System.out.println( this.index );	//inner类变量
			System.out.println( Outer.this.index );	//Outer类变量
		}
	}
	void print()
	{
		Inner inner = new Inner();
		inner.print();
	}

	Inner getInner() //提高访问内部类的方法
	{
		return new Inner();
	}

	public static void main( String[] args )
	{
		Outer outer = new Outer();
		//outer.print();
		Outer.Inner inner = outer.getInner();
		inner.print();
	}
}

class Test
{
	/*public static void main( String[] args )
	{
		Outer outer = new Outer();
		//outer.print();
		Outer.Inner inner = outer.getInner();
		inner.print();
	}*/
}
或者
//Outer.java
class Outer
{
	private int index = 100;
	class Inner
	{
		private int index = 50;
		void print()
		{
			int index = 30;
			System.out.println( index );	//局部变量
			System.out.println( this.index );	//inner类变量
			System.out.println( Outer.this.index );	//Outer类变量
		}
	}
	void print()
	{
		Inner inner = new Inner();
		inner.print();
	}

	Inner getInner() //提高访问内部类的方法
	{
		return new Inner();
	}

	public static void main( String[] args )
	{
		Outer outer = new Outer();
		//outer.print();
		//Outer.Inner inner = outer.getInner();
		Inner inner = outer.getInner();
		inner.print();
	}
}

class Test
{
	/*public static void main( String[] args )
	{
		Outer outer = new Outer();
		//outer.print();
		Outer.Inner inner = outer.getInner();
		inner.print();
	}*/
}


E:\zieckey\Lesson4>javac Outer.java

E:\zieckey\Lesson4>java Outer
30
50
100

E:\zieckey\Lesson4>


内部类能直接通过new来生成呢？

//Outer.java
class Outer
{
	private int index = 100;
	class Inner
	{
		private int index = 50;
		void print()
		{
			int index = 30;
			System.out.println( index );	//局部变量
			System.out.println( this.index );	//inner类变量
			System.out.println( Outer.this.index );	//Outer类变量
		}
	}
	void print()
	{
		Inner inner = new Inner();
		inner.print();
	}

	Inner getInner() //提高访问内部类的方法
	{
		return new Inner();
	}

	public static void main( String[] args )
	{
		Outer outer = new Outer();
		//outer.print();
		//Outer.Inner inner = outer.getInner();
		//Inner inner = outer.getInner();
		Inner inner = new Inner();
		inner.print();
	}
}

class Test
{
	/*public static void main( String[] args )
	{
		Outer outer = new Outer();
		//outer.print();
		Outer.Inner inner = outer.getInner();
		inner.print();
	}*/
}
E:\zieckey\Lesson4>javac Outer.java
Outer.java:33: 无法从静态上下文中引用非静态 变量 this
                Inner inner = new Inner();
                              ^
1 错误

看来这样是不行的，内部类不能直接通过new来生成
但是可以通过外部类来生成：
//Outer.java
class Outer
{
	private int index = 100;
	class Inner
	{
		private int index = 50;
		void print()
		{
			int index = 30;
			System.out.println( index );	//局部变量
			System.out.println( this.index );	//inner类变量
			System.out.println( Outer.this.index );	//Outer类变量
		}
	}
	void print()
	{
		Inner inner = new Inner();
		inner.print();
	}

	Inner getInner() //提高访问内部类的方法
	{
		return new Inner();
	}
}

class Test
{
	public static void main( String[] args )
	{
		Outer outer = new Outer();

		//这里如果直接用new生成Inner对象的话，
		//在Inner类的内部所访问的Outer类的数据成员就属于没有初始化的数据变量，
		//这显然是不行的，所以要通过Outer类的实例outer outer.new 来生成Inner对象
		Outer.Inner inner = outer.new Inner();
		inner.print();
	}
}

内部类还可以放到成员方法中，或者条件判断语句中：

//Outer.java
class Outer
{
	private int index = 100;
	void fn()
	{
		if( true )
		{
			class Middle
			{
				private int index = 70;
				class Inner
				{
					private int index = 50;
					void print()
					{
						int index = 30;
						System.out.println( index );	//局部变量
						System.out.println( this.index );	//inner类变量
						System.out.println( Middle.this.index );	//Middle类变量
						System.out.println( Outer.this.index );	//Outer类变量
					}
				}
			}//class Middle
		}//end if
	}//end fn

}

class Test
{
	public static void main( String[] args )
	{
		Outer outer = new Outer();
	}
}
也就是说不管内部类嵌套有多深，都可以随意访问外部类的成员。


//Outer.java
class Outer
{
	private int index = 100;
	void fn( int a )
	{
		int b;
		if( true )
		{
			class Middle
			{
				private int index = 70;
				class Inner
				{
					private int index = 50;
					void print()
					{
						int index = 30;
						System.out.println( index );	//局部变量
						System.out.println( this.index );	//inner类变量
						System.out.println( Middle.this.index );	//Middle类变量
						System.out.println( Outer.this.index );	//Outer类变量
						a = 5;
						b = 6;
					}
				}
			}//class Middle
		}//end if
	}//end fn

}

class Test
{
	public static void main( String[] args )
	{
		Outer outer = new Outer();
	}
}

E:\zieckey\Lesson4>javac Outer.java
Outer.java:23: 从内部类中访问局部变量 a；需要被声明为最终类型
                                                a = 5;
                                                ^
Outer.java:24: 从内部类中访问局部变量 b；需要被声明为最终类型
                                                b = 6;
                                                ^
2 错误

看到错误提示了，我们将a，b声明为final类型：
//Outer.java
class Outer
{
	private int index = 100;
	void fn( final int a )
	{
		final int b = 10;
		if( true )
		{
			class Middle
			{
				private int index = 70;
				class Inner
				{
					private int index = 50;
					void print()
					{
						int index = 30;
						System.out.println( index );	//局部变量
						System.out.println( this.index );	//inner类变量
						System.out.println( Middle.this.index );	//Middle类变量
						System.out.println( Outer.this.index );	//Outer类变量
						System.out.println( a );
						System.out.println( b );
					}
				}
			}//class Middle
		}//end if
	}//end fn

}

class Test
{
	public static void main( String[] args )
	{
		Outer outer = new Outer();
	}
}
这样编译就没有问题，


从内部类派生类的用法:
//Car.java
class Car
{
	class Wheel
	{
	}
}
class PanelWheel extends Car.Wheel
{
	public static void main( String[] args )
	{
		PanelWheel pw = new PanelWheel();
	}
}
E:\zieckey\Lesson4>javac Car.java
Car.java:8: 需要包含 Car.Wheel 的封闭实例
class PanelWheel extends Car.Wheel
^
1 错误
这里是因为,外部内还没有产生实例对象,内部类就不可能存在,那和谈初始化呢?

这时候我们需要像下面的方法那样从内部类派生类:

//Car.java
class Car
{
	class Wheel
	{
	}
}
class PanelWheel extends Car.Wheel
{
	PanelWheel( Car car )
	{
		car.super();
	}
	public static void main( String[] args )
	{
		Car car = new Car();
		PanelWheel pw = new PanelWheel( car );
	}
}

可以通过内部类实现接口:
//Animal.java
interface Animal
{
	void eat();
	void sleep();
}

class Zoo
{
	private class Tiger implements Animal
	{
		public void eat()
		{
			System.out.println("tiger eat");
		}
		public void sleep()
		{
			System.out.println("tiger sleep");
		}
	}
	Animal getAnimal()
	{
		return new Tiger();
	}
}

class Test
{
	public static void main(String[] args)
	{
		Zoo z=new Zoo();
		Animal an=z.getAnimal();
		an.eat();
		an.sleep();
	}
}
E:\zieckey\Lesson4>javac Animal.java

E:\zieckey\Lesson4>java Test
tiger eat
tiger sleep

E:\zieckey\Lesson4>

另外我们还可以这样实现接口:
//Animal.java
interface Animal
{
	void eat();
	void sleep();
}

class Zoo
{
	private class Tiger implements Animal
	{
		public void eat()
		{
			System.out.println("tiger eat");
		}
		public void sleep()
		{
			System.out.println("tiger sleep");
		}
	}
	/*Animal getAnimal()
	{
		return new Tiger();
	}*/
	Animal getAnimal()
	{
		return new Animal()//这里就定义了一个类,只是这个类没有名字,这就是匿名的内部类
		{
			public void eat()
			{
				System.out.println("animal eat");
			}
			public void sleep()
			{
				System.out.println("animal sleep");
			}
		};//这个地方的分号不能少,因为这是一个return语句
	}
}

class Test
{
	public static void main(String[] args)
	{
		Zoo z=new Zoo();
		Animal an=z.getAnimal();
		an.eat();
		an.sleep();
	}
}
E:\zieckey\Lesson4>javac Animal.java

E:\zieckey\Lesson4>java Test
animal eat
animal sleep

E:\zieckey\Lesson4>

我们为什么使用内部类
1、在内部类（inner class）中，可以随意的访问外部类的成员，这可以让我们更好地组织管理我们的代码，增强代码的可读性。
2、内部类可以用于创建适配器类，适配器类是用于实现接口的类。使用内部类来实现接口，可以更好地定位与接口关联的方法在代码中的位置。
3、内部类的更多用法。
内部类可以隐藏用户实现接口的细节,
//Animal.java
interface Animal
{
	void eat();
	void sleep();
}
class Zoo
{
	private class Tiger implements Animal
	{
		public void eat()
		{
			System.out.println("tiger eat");
		}
		public void sleep()
		{
			System.out.println("tiger sleep");
		}
	}
	Animal getAnimal()
	{
		return new Tiger();
	}
}
class Test
{
	public static void main(String[] args)
	{
		Zoo z=new Zoo();
		Animal an=z.getAnimal();
		an.eat();
		an.sleep();
	}
}


假如我们想派生一个类同时实现一个接口,但是在父类中有一个方法和接口中方法同名,
这个时候,我们就可以通过内部类实现:
//Machine.java
interface Machine
{
	void run();
}
class Person
{
	void run()
	{
		System.out.println( "Person is running..." );
	}
}
//Robot类继承自Person类,同时要实现一个Machine接口
//而这个接口方法和Person类的成员方法同名,这个时候就可以通过内部类实现
class Robot extends Person
{
	private class MachineHeart implements Machine
	{
		public void run()
		{
			System.out.println( "Machine's heart is running..." );
		}
	}
	Machine getMachine()
	{
		return new MachineHeart();
	}
}

class Test
{
	public static void main(String[] args)
	{
		Robot robot = new Robot();
		Machine m = robot.getMachine();
		m.run();
		robot.run();
	}
}

内部类解决多重继承的问题:
//A.java
class A
{
	void fn1()
	{
	}
}

abstract class B
{
	abstract void fn2();
}

class C extends A
{
	B getB()
	{
		return new B()//B是抽象的,所以必须实现它的抽象方法
		{
			public void fn2()
			{
			}
		};
	}
}

class Test
{
	static void method1(A a)
	{
		a.fn1();
	}
	static void method2(B b)
	{
		b.fn2();
	}
	public static void main(String[] args)
	{
		C c=new C();
		method1(c);
		method2(c.getB());
	}
}




Java中的异常处理:
Java程序在执行过程中如出现异常，会自动生成一个异常类对象，该异常对象将被提交给Java运行时系统，这个过程称为抛出(throw)异常。
当Java运行时系统接收到异常对象时，会寻找能处理这一异常的代码并把当前异常对象交给其处理，这一过程称为捕获(catch)异常。
如果Java运行时系统找不到可以捕获异常的方法，则运行时系统将终止，相应的Java程序也将退出。
try/catch/finally语句。

对于RuntimeException，通常不需要我们去捕获，这类异常由Java运行系统自动抛出并自动处理。
如果父类中的方法抛出多个异常，则子类中的覆盖方法要么抛出相同的异常，要么抛出异常的子类，但不能抛出新的异常（注：构造方法除外）。
我们可以在方法声明时，声明一个不会抛出的异常，Java编译器就会强迫方法的使用者对异常进行处理。这种方式通常应用于abstract base class和interface中。



//Excep.java
class Excep
{
	public int division(int a,int b)
	{
		return a/b;
	}
}

class ExcepTest
{
	public static void main(String[] args) //throws Exception
	{
		Excep excep = new Excep();
		excep.division( 5, 0 );
		System.out.println( "Finish" );//这个语句是不被执行的
	}
}
E:\zieckey\Lesson4>java ExcepTest
Exception in thread "main" java.lang.ArithmeticException: / by zero
        at Excep.division(Excep.java:6)
        at ExcepTest.main(Excep.java:15)
这里是个异常处理,被0除

//Excep.java
class Excep
{
	public int division(int a,int b)
	{
		return a/b;
	}
}

class ExcepTest
{
	public static void main(String[] args) //throws Exception
	{
		Excep excep = new Excep();
		try
		{
			excep.division(5,0);
		}
		catch(Exception e)
		{
			System.out.println( "Can't divide by zero!" );
		}
		System.out.println( "Finish" );
	}
}

E:\zieckey\Lesson4>java ExcepTest
Can't divide by zero!
Finish


try语句块中的语句在发生异常时就跳转到catch语句

//Excep.java
class Excep
{
	public int division(int a,int b)
	{
		return a/b;
	}
}

class ExcepTest
{
	public static void main(String[] args) //throws Exception
	{
		Excep excep = new Excep();
		try
		{
			excep.division(5,0);//try语句块中的语句在发生异常时就跳转到catch语句
			System.out.println( "Exception" );//该语句是不被执行的
		}
		catch(Exception e)
		{
			System.out.println( "Can't divide by zero!" );
		}
		System.out.println( "Finish" );
	}
}
E:\zieckey\Lesson4>javac Excep.java

E:\zieckey\Lesson4>java ExcepTest
Can't divide by zero!
Finish

打印异常信息:
	catch(Exception e)
	{
		//这三种方法都可以
		System.out.println(e.getMessage());
		System.out.println(e.toString());
		e.printStackTrace();
	}
我们在写程序的时候,如果编写的代码可能引发异常,那么在编写的时候就进行异常捕获,
例如这里的 a/b 处:
		try
		{
			return a/b;
		}
		catch(Exception e)
		{

			e.printStackTrace();
			return 0;
		}
那么在后面调用的时候就不需要进行异常处理了.
如果在编写代码的时候不想自己处理异常,那么可以抛出一个异常,让用户调用的时候自己处理.
这里可以这样,例如:
//Excep.java
class Excep
{
	public int division(int a,int b) throws Exception
	{
		return a/b;
	}
}

class ExcepTest
{
	public static void main(String[] args) //throws Exception
	{
		Excep excep = new Excep();
		excep.division(5,0);
		System.out.println( "Finish" );
	}
}
E:\zieckey\Lesson4>javac Excep.java
Excep.java:15: 未报告的异常 java.lang.Exception；必须对其进行捕捉或声明以便抛出
                excep.division(5,0);
                              ^
1 错误
这里就告诉用户在调用抛出异常的函数或方法时,必须进行异常处理.

可以写多个catch语句

我们还可以抛出自己的异常:
//Excep.java
class Excep
{
	public int division(int a,int b) throws Exception
	{
		try
		{
			return a/b;
		}
		catch(Exception e)
		{

			e.printStackTrace();
			throw new Exception( "Can't be divided by zero" );
		}
	}
}

class ExcepTest
{
	public static void main(String[] args) //throws Exception
	{
		Excep excep = new Excep();
		try
		{
			excep.division(5,0);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		System.out.println( "Finish" );
	}
}
E:\zieckey\Lesson4>javac Excep.java

E:\zieckey\Lesson4>java ExcepTest
java.lang.ArithmeticException: / by zero
        at Excep.division(Excep.java:8)
        at ExcepTest.main(Excep.java:26)
java.lang.Exception: Can't be divided by zero
        at Excep.division(Excep.java:14)
        at ExcepTest.main(Excep.java:26)
Finish

E:\zieckey\Lesson4>


另外,我们也可以自定义异常:
//Excep.java
class Excep
{
	public int division(int a,int b) throws ArithmeticException,DivisorIsMinusException
	{
		//try
		//{
			if(b<0)
				throw new DivisorIsMinusException("Divisor can't be minus");
			return a/b;
		/*}
		catch(Exception e)
		{

			e.printStackTrace();
			throw new Exception( "Can't be divided by zero" );
		}*/
	}
}
class DivisorIsMinusException extends Exception
{
	DivisorIsMinusException(String str)
	{
		super(str);
	}
}

class ExcepTest
{
	public static void main(String[] args) //throws Exception
	{
		Excep excep = new Excep();
		try
		{
			excep.division(5,0);
		}
		catch(ArithmeticException e)
		{
			System.out.println(e.toString());
		}
		catch(DivisorIsMinusException ex)
		{
			System.out.println(ex.toString());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		System.out.println( "Finish" );
	}
}
E:\zieckey\Lesson4>javac Excep.java

E:\zieckey\Lesson4>java ExcepTest
java.lang.ArithmeticException: / by zero
Finish
如果是excep.division(5,-1);
那么
E:\zieckey\Lesson4>javac Excep.java

E:\zieckey\Lesson4>java ExcepTest
DivisorIsMinusException: Divisor can't be minus
Finish


//Excep.java
class Excep
{
	public int division(int a,int b) throws ArithmeticException,DivisorIsMinusException
	{
		//try
		//{
			if(b<0)
				throw new DivisorIsMinusException("Divisor can't be minus");
			return a/b;
		/*}
		catch(Exception e)
		{

			e.printStackTrace();
			throw new Exception( "Can't be divided by zero" );
		}*/
	}
}
class DivisorIsMinusException extends Exception
{
	DivisorIsMinusException(String str)
	{
		super(str);
	}
}

class ExcepTest
{
	public static void main(String[] args) //throws Exception
	{
		Excep excep = new Excep();
		try
		{
			excep.division(5,-1);
			return;
		}
		catch(ArithmeticException e)
		{
			System.out.println(e.toString());
		}
		catch(DivisorIsMinusException ex)
		{
			System.out.println(ex.toString());
			return;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally//无论异常产生与否,这里的语句都要执行
		{
			System.out.println("Finally");
		}
		System.out.println( "Finish" );
	}
}
E:\zieckey\Lesson4>javac Excep.java

E:\zieckey\Lesson4>java ExcepTest
DivisorIsMinusException: Divisor can't be minus
Finally

这里就说明无论异常产生与否,finally语句都要执行,即使是在try或catch中有return语句.
但是有一个终止程序的方法 System.exit 可以不让finally语句执行.



如果父类中的方法抛出多个异常，则子类中的覆盖方法要么抛出相同的异常，要么抛出异常的子类，但不能抛出新的异常（注：构造方法除外）。

//Excep.java
class Excep
{
	public int division(int a,int b) throws ArithmeticException,DivisorIsMinusException
	{
		if(b<0)
			throw new DivisorIsMinusException("Divisor can't be minus");
		return a/b;
	}
}
class ChildExcep extends Excep
{
	public int division(int a,int b) throws FileNotFoundException
	{
		return a/b;
	}
}

class DivisorIsMinusException extends Exception
{
	DivisorIsMinusException(String str)
	{
		super(str);
	}
}

class ExcepTest
{
	public static void main(String[] args) //throws Exception
	{
		Excep excep = new Excep();
		try
		{
			excep.division(5,-1);
			return;
		}
		catch(ArithmeticException e)
		{
			System.out.println(e.toString());
		}
		catch(DivisorIsMinusException ex)
		{
			System.out.println(ex.toString());
			System.exit(-1);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally//无论异常产生与否,这里的语句都要执行
		{
			System.out.println("Finally");
		}
		System.out.println( "Finish" );
	}
}
E:\zieckey\Lesson4>javac Excep.java
Excep.java:13: 找不到符号
符号： 类 FileNotFoundException
位置： 类 ChildExcep
        public int division(int a,int b) throws FileNotFoundException
                                                ^
1 错误

构造方法除外,可以抛出其他的异常.
//Excep.java
import java.io.*;
class Excep
{
	public int division(int a,int b) throws ArithmeticException,DivisorIsMinusException
	{
		if(b<0)
			throw new DivisorIsMinusException("Divisor can't be minus");
		return a/b;
	}
}
class ChildExcep extends Excep
{
	ChildExcep() throws FileNotFoundException
	{
	}
	public int division(int a,int b) throws ArithmeticException,DivisorIsMinusException
	{
		return a/b;
	}
}

class DivisorIsMinusException extends Exception
{
	DivisorIsMinusException(String str)
	{
		super(str);
	}
}

class ExcepTest
{
	public static void main(String[] args) //throws Exception
	{
		Excep excep = new Excep();
		try
		{
			excep.division(5,-1);
			return;
		}
		catch(ArithmeticException e)
		{
			System.out.println(e.toString());
		}
		catch(DivisorIsMinusException ex)
		{
			System.out.println(ex.toString());
			System.exit(-1);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally//无论异常产生与否,这里的语句都要执行
		{
			System.out.println("Finally");
		}
		System.out.println( "Finish" );
	}
}


为什么在子类中的抛出异常要小于等于父类中的异常呢？
这是为了进行面向对象设计时的类派生和继承用的．
看下面的代码：
//Excep.java
import java.io.*;
class Excep
{
	public int division(int a,int b) throws ArithmeticException,DivisorIsMinusException
	{
		if(b<0)
			throw new DivisorIsMinusException("Divisor can't be minus");
		return a/b;
	}
}
class ChildExcep extends Excep
{
	ChildExcep() throws FileNotFoundException
	{
	}
	public int division(int a,int b) throws ArithmeticException,DivisorIsMinusException
	{
		return a/b;
	}
}

class DivisorIsMinusException extends Exception
{
	DivisorIsMinusException(String str)
	{
		super(str);
	}
}

class ExcepTest
{
	public static int method1(Excep excep)
	{
		try
		{
			return excep.division(5,0);
		}
		catch(ArithmeticException e)
		{
			System.out.println(e.toString());
		}
		catch(DivisorIsMinusException ex)
		{
			System.out.println(ex.toString());
		}
		return 0;
	}
	public static void main(String[] args) //throws Exception
	{
		ChildExcep ce=new ChildExcep();
		method1(ce);//这里如果子类允许抛出父类中没有的异常，
					//那么继承来的方法就没有对所有的处理完，这样的类继承是不安全的　
		Excep excep = new Excep();
		try
		{
			excep.division(5,-1);
			return;
		}
		catch(ArithmeticException e)
		{
			System.out.println(e.toString());
		}
		catch(DivisorIsMinusException ex)
		{
			System.out.println(ex.toString());
			System.exit(-1);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally//无论异常产生与否,这里的语句都要执行
		{
			System.out.println("Finally");
		}
		System.out.println( "Finish" );
	}
}




Java编程规范
1. package的命名 package 的名字由全部小写的字母组成，例如：cn.mybole。
2. class和interface的命名 class和interface的名字由大写字母开头而其他字母都小写的单词组成，例如：Person，RuntimeException。
3. class变量的命名 变量的名字用一个小写字母开头，后面的单词用大写字母开头,例如：index，currentImage。
4. class方法的命名
   方法的名字用一个小写字母开头，后面的单词用大写字母开头,例如：run()，getBalance()。
5. static final变量的命名 static final变量的名字所有字母都大写，并且能表示完整含义。例如：PI，PASSWORD。
6. 参数的命名 参数的名字和变量的命名规范一致。
7. 数组的命名 数组应该总是用这样的方式来命名：byte[] buffer。



Lesson4上
Java的常用包：
java.applet：包含一些用于创建Java小应用程序的类。
java.awt：包含一些用于编写与平台无关的图形界面(GUI)应用程序的类。
java.io：包含一些用作输入输出(I/O)处理的类。
java.lang：包含一些Java语言的基本类与核心类，如String、Math、Integer、System和Runtime，提供常用的功能，这个包中的所有类是被隐式导入的。
java.net：包含用于建立网络连接的类，与java.io同时使用完成与网络有关的读写。
java.util：包含一些实用工具类和数据结构类。


“==”和“equals”的用法
在Java中，boolean、byte、short、int、long、char、float、double这八种是基本数据类型，其余的都是引用类型。
“==”是比较两个变量的值是否相等，“equals”是比较两个对象变量所代表的对象的内容是否相等。


//StringTest.java
public class StringTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "abc";
		String str2 = "abc";
		if ( str1 == str2 ){
			System.out.println( "str1 == str2" );
		}
		else{
			System.out.println( "str1 != str2" );
		}
	}
}

E:\JavaLesson\Lesson5>javac StringTest.java
E:\JavaLesson\Lesson5>java StringTest
str1 == str2

//StringTest.java
public class StringTest {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = new String("abc");
		String str2 = new String("abc");
		if ( str1 == str2 ){
			System.out.println( "str1 == str2" );
		}
		else{
			System.out.println( "str1 != str2" );
		}
	}
}
E:\JavaLesson\Lesson5>javac StringTest.java
E:\JavaLesson\Lesson5>java StringTest
str1 != str2

//StringTest.java
/**
 * @author apple
 *
 */
public class StringTest {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = new String("abc");
		String str2 = new String("abc");
		if ( str1.equals(str2) ) {
			System.out.println( "str1 equals str2" );
		}
		else{
			System.out.println( "str1 don't equals str2" );
		}
	}
}
E:\JavaLesson\Lesson5>javac StringTest.java
E:\JavaLesson\Lesson5>java StringTest
str1 equals str2

字符串的“+”“+=”重载操作符
//StringTest.java
/**
 * @author apple
 *
 */
public class StringTest {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = new String("abc");
		/*String str2 = new String("abc");
		if ( str1.equals(str2) ) {
			System.out.println( "str1 equals str2" );
		}
		else{
			System.out.println( "str1 don't equals str2" );
		}*/
		int i = 9;
		float f=5.6f;
		char ch = 'a';
		System.out.println( str1 + i + f + ch );
	}
}
E:\JavaLesson\Lesson5>javac StringTest.java
E:\JavaLesson\Lesson5>java StringTest
abc95.6a

String和StringBuffer
	String str=“abc”;
    int i=3;
    float f=4.5f;
    char ch='a';
    boolean b=true;
    System.out.println(str + i + f + ch + b);

    String类对象一个常量对象。
    String str=“abc”;
    str=“def”;
在处理大量字符串的程序中，我们通常用StringBuffer来替代String。
针对String的“+”和“+=”，是Java中唯一被重载的操作符；在Java中，不允许程序员重载操作符。


//StringTest.java
/**
 * @author apple
 *
 */
public class StringTest {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = new String("abc");
		/*String str2 = new String("abc");
		if ( str1.equals(str2) ) {
			System.out.println( "str1 equals str2" );
		}
		else{
			System.out.println( "str1 don't equals str2" );
		}*/
		int i = 9;
		float f=5.6f;
		char ch = 'a';
		boolean b = false;
		//System.out.println( str1 + i + f + ch );
		StringBuffer sb=new StringBuffer();
		sb.append(str1).append(i).append(f).append(ch).append(b);
		System.out.println(sb.toString());
	}
}
E:\JavaLesson\Lesson5>javac StringTest.java
E:\JavaLesson\Lesson5>java StringTest
abc95.6afalse


数组：
//StringTest.java
/**
 * @author apple
 *
 */
public class StringTest
{
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		int[] num=new int[3];
		for(int i=0;i<num.length;i++)
		{
			System.out.println(num[i]);
		}
		num=null;//让该对象成为垃圾内存，之后java虚拟机就会在需要的时候回收这块内存
	}
}
E:\JavaLesson\Lesson5>javac StringTest.java
E:\JavaLesson\Lesson5>java StringTest
0
0
0


//StringTest.java
/**
 * @author apple
 *
 */
public class StringTest
{
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Student[] students;
		students=new Student[3];
		for(int i=0;i<students.length;i++)
		{
			System.out.println(students[i]);
		}
	}
}

class Student
{
	String name;
	int age;
	Student( String name,int age )
	{
		this.name=name;
		this.age=age;
	}
}
E:\JavaLesson\Lesson5>javac StringTest.java
E:\JavaLesson\Lesson5>java StringTest
null
null
null

//StringTest.java
/**
 * @author apple
 *
 */
public class StringTest
{
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Student[] students;
		students=new Student[3];//此处仅仅定义了三个Student对象的应用，但还没有分配内存空间
		System.out.println( students );
		for(int i=0;i<students.length;i++)
		{
			System.out.println(students[i]);
		}
		students[0] = new Student( "LiSi", 19 );//此处才开始分配内存空间
		students[1] = new Student( "ZhangSan", 21 );//students对象的引用在栈内存,
		students[2] = new Student( "WangMazi", 20 );//students[i]的引用在堆内存,
													//students[i]的具体值也在堆内存,
		for(int i=0;i<students.length;i++)
		{
			System.out.println(students[i]);
		}
	}
}
class Student
{
	String name;
	int age;
	Student( String name,int age )
	{
		this.name=name;
		this.age=age;
	}
}
E:\JavaLesson\Lesson5>javac StringTest.java

E:\JavaLesson\Lesson5>java StringTest
[LStudent;@757aef
null
null
null
Student@d9f9c3
Student@9cab16
Student@1a46e30

打印命令行参数:
		if(args.length>0)
		{
			for(int i=0;i<args.length;i++)
			{
				System.out.println(args[i]);
			}
		}

函数的调用:
在Java中，传参时，都是以传值的方式进行。
对于基本数据类型，传递的是数据的拷贝；对于引用类型，传递的引用的拷贝。
//StringTest.java
/**
 * @author apple
 *
 */
public class StringTest
{
	/**
	 * @param args
	 */
	public static void change(int x,int y)
	{
		x=x+y;
		y=x-y;
		x=x-y;
	}
	public static void change(int[] num)
	{
		num[0]=num[0]+num[1];
		num[1]=num[0]-num[1];
		num[0]=num[0]-num[1];
	}
	public static void change(Point pt)
	{
		pt.x=pt.x+pt.y;
		pt.y=pt.x-pt.y;
		pt.x=pt.x-pt.y;
	}
	public static void main(String[] args)
	{
		int x=3;
		int y=4;
		change(x,y);
		System.out.println("change(int x,int y)"+"x="+x+","+"y="+y);//这里不会交换
		int[] num=new int[]{3,4};
		change(num);
		System.out.println("change(int[] num)"+"x="+num[0]+","+"y="+num[1]);
		Point pt=new Point();
		pt.x=3;
		pt.y=4;
		change(pt);
		System.out.println("change(Point pt)"+"x="+pt.x+","+"y="+pt.y);
	}
}
class Student
{
	String name;
	int age;
	Student( String name,int age )
	{
		this.name=name;
		this.age=age;
	}
}
class Point
{
	int x,y;
}
E:\JavaLesson\Lesson5>javac StringTest.java

E:\JavaLesson\Lesson5>java StringTest
change(int x,int y)x=3,y=4
change(int[] num)x=4,y=3
change(Point pt)x=4,y=3



class StringTest
{
	public static void change(Point pt)
	{
		pt.x=pt.x+pt.y;
		pt.y=pt.x-pt.y;
		pt.x=pt.x-pt.y;
	}
	public static void main(String[] args)
	{
		Point pt=new Point();
		pt.x=3;
		pt.y=4;
		change(pt);
		System.out.println("x="+pt.x);
		System.out.println("y="+pt.y);
	}
}
class Point{int x, y;}


在打印一个类对象的时候,例如:
	class Point{int x, y;}
	Point pt=new Point();
	System.out.println(pt);//这里打印的很可能是：“Point@9cab16”之类的信息

这样会自动调用Object:toString()方法,去打印一个类对象的相关信息,
当我们重载Object:toString()该方法的时候，就可以打印我们自己定义的信息，例如：
	class Point
	{
		int x, y;
		public String toString()
		{
			return "x="+x+","+"y="+y;
		}
	}
	Point pt=new Point();
	System.out.println(pt);//这里打印的很可能是：“x=3,y=6”之类的信息了


对象的克隆(clone)
为了获取对象的一份拷贝，我们可以利用Object类的clone()方法。
在派生类中覆盖基类的clone()方法，并声明为public。
在派生类的clone()方法中，调用super.clone()。
在派生类中实现Cloneable接口。

为什么我们在派生类中覆盖Object的clone()方法时，一定要调用super.clone()呢？
在运行时刻，Object中的clone()识别出你要复制的是哪一个对象，
然后为此对象分配空间，并进行对象的复制，将原始对象的内容一一复制到新对象的存储空间中。

//StringTest.java
public class StringTest
{
	public static void main(String[] args)
	{
		Student s1=new Student("zhangsan",18 );
		Student s2=(Student)s1.clone();
		s2.name="lisi";
		s2.age=20;
		System.out.println("name="+s1.name+","+"age="+s1.age);
	}
}
class Student implements Cloneable
{
	String name;
	int age;
	Student( String name,int age )
	{
		this.name=name;
		this.age=age;
	}
	public Object clone()
	{
		Object o=null;
		try
		{
			o=(Object)super.clone();
		}
		catch(CloneNotSupportedException e)
		{
			System.out.println(e.toString());
		}
		return o;
	}
}
E:\JavaLesson\Lesson5>javac StringTest.java

E:\JavaLesson\Lesson5>java StringTest
name=zhangsan,age=18
这就说明了没有改变原来的对象的值



//StringTest.java
public class StringTest
{
	public static void main(String[] args)
	{
		Professor p=new Professor("wangwu",50);
		Student s1=new Student("zhangsan",18,p);
		Student s2=(Student)s1.clone();
		s2.p.name="lisi";
		s2.p.age=30;
		//System.out.println("name="+s1.name+","+"age="+s1.age);
		System.out.println("name="+s1.p.name+","+"age="+s1.p.age);
	}
}

class Professor
{
	String name;
	int age;
	Professor(String name,int age)
	{
		this.name=name;
		this.age=age;
	}
}

class Student implements Cloneable
{
	String name;
	int age;
	Professor p;
	Student( String name,int age, Professor p)
	{
		this.name = name;
		this.age = age;
		this.p = p;
	}
	public Object clone()
	{
		Object o=null;
		try
		{
			o=(Object)super.clone();
		}
		catch(CloneNotSupportedException e)
		{
			System.out.println(e.toString());
		}
		return o;
	}
}
编译运行后：name=lisi,age=30
这里就说明了对s2的修改影响到了s1中Professor对象p的值，
这是为什么呢？
我们想想，clone方法是对类中所有变量值进行了一次拷贝，
前面我们的年龄age变量是基本类型变量，所以拷贝的是数据，
而我们的Professor变量p是引用类型，所以拷贝的是引用，而数据没有拷贝，
所以我们修改的时候，将Professor类对象p的值也修改了。
但是我们又想到，为什么String的对象name也是引用，为什么没有被修改呢？
是不是String也重载了clone方法呢？
没有，可以去看看String类的帮助文档。
这里是因为，一个String对象是一个常量对象，
String str = “Zhangsan”；这个语句相当于先声名了一个Zhangsan的对象，
然后将其引用赋值给str，所以在clone的时候就没有影响到原来的变量。

那么我们如何将Professor类同杨的复制一份呢？


//StringTest.java
public class StringTest
{
	public static void main(String[] args)
	{
		Professor p=new Professor("wangwu",50);
		Student s1=new Student("zhangsan",18,p);
		Student s2=(Student)s1.clone();
		s2.p.name="lisi";
		s2.p.age=30;
		System.out.println("name="+s1.p.name+","+"age="+s1.p.age);
	}
}

class Professor implements Cloneable
{
	String name;
	int age;
	Professor(String name,int age)
	{
		this.name=name;
		this.age=age;
	}
	public Object clone()
	{
		Object o=null;
		try
		{
			o=super.clone();
		}
		catch(CloneNotSupportedException e)
		{
			System.out.println(e.toString());
		}
		return o;
	}
}
class Student implements Cloneable
{
	String name;
	int age;
	Professor p;
	Student(String name,int age,Professor p)
	{
		this.name=name;
		this.age=age;
		this.p=p;
	}
	public Object clone()
	{
		Student o=null;
		try
		{
			o=(Student)super.clone();
		}
		catch(CloneNotSupportedException e)
		{
			System.out.println(e.toString());
		}
		o.p=(Professor)p.clone();
		return o;
	}
}
编译运行后：name=wangwu,age=50

为什么我们在派生类中覆盖Object的clone()方法时，一定要调用super.clone()呢？
在运行时刻，Object中的clone()识别出你要复制的是哪一个对象，
然后为此对象分配空间，并进行对象的复制，将原始对象的内容一一复制到新对象的存储空间中。


Lesson6

数组对关方法：

数组的拷贝：System.arraycopy
//ArrayTest.java
public class ArrayTest
{
	public static void main(String[] args)
	{
		int[] num1=new int[]{1,2,3};
		int[] num2=new int[10];
		System.arraycopy(num1,0,num2,8,2);
		for(int i=0;i<num2.length;i++)
		{
			System.out.println(num2[i]);
		}
	}
}

下面对象数组的复制：
//ArrayTest.java
public class ArrayTest
{
	public static void main(String[] args)
	{
		Point[] pts1=new Point[]{new Point(1,1),new Point(2,2),new Point(3,3)};
		Point[] pts2=new Point[3];
		System.arraycopy(pts1,0,pts2,0,pts1.length);
		for(int i=0;i<pts2.length;i++)
		{
			System.out.println("x="+pts2[i].x+","+"y="+pts2[i].y);
		}
		pts2[1].x=5;
		pts2[1].y=5;
		System.out.println("x="+pts1[1].x+","+"y="+pts1[1].y);//这里拷贝的是对象的引用
	}
}
class Point
{
	int x,y;
	Point(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
}
运行结果：
x=1,y=1
x=2,y=2
x=3,y=3
x=5,y=5
从结果就可以看出对类数组的拷贝时是拷贝的对象的引用，
拷贝后，对拷贝的对象进行操作会反映到原对象上。

数组的排序：
//ArrayTest.java
import java.util.Arrays;
public class ArrayTest
{
	public static void main(String[] args)
	{
		int[] num=new int[]{3,1,2};
		Arrays.sort(num);
		for(int i=0;i<num.length;i++)
		{
			System.out.println(num[i]);
		}
		int index=Arrays.binarySearch(num,3);
		System.out.println("index="+index);
		System.out.println("element="+num[index]);
	}
}
运行结果
1
2
3
index=2
element=3


但是要对一个对象数组进行排序，就要实现一个 compareTo接口
例如：
//ArrayTest.java
import java.util.Arrays;
public class ArrayTest
{
	public static void main(String[] args)
	{
		Student[] ss=new Student[]{new Student(3,"zhangsan"),
				   new Student(2,"lisi"),
				   new Student(4,"wangwu"),
				   new Student(4,"mybole")};
		Arrays.sort(ss);
		for(int i=0;i<ss.length;i++)
		{
			System.out.println(ss[i]);
		}
		}
}
class Student implements Comparable
{
	int num;
	String name;
	Student(int num,String name)
	{
		this.num=num;
		this.name=name;
	}
	public String toString()
	{
		return "number="+num+","+"name="+name;
	}
	public int compareTo(Object o)
	{
		Student s=(Student)o;
		int result=num>s.num ? 1 : (num==s.num ? 0 : -1);
		if(0==result)
		{
			result=name.compareTo(s.name);//
		}
		return result;
	}
}
运行结果：
number=2,name=lisi
number=3,name=zhangsan
number=4,name=mybole
number=4,name=wangwu

同样我们也可以通过Arrays.binarySearch搜索对象数组中数据
		int index=Arrays.binarySearch(ss,new Student(2,"lisi"));
		System.out.println("index="+index);
		System.out.println(ss[index]);




针对八种基本数据类型定义的相应的引用类型－封装类。
基本数据类型	封装类
	boolean	Boolean
	byte	Byte
	short	Short
	int		Integer
	long	Long
	char	Character
	float	Float
	double	Double


class Test
{
	public static void main(String[] args)
	{
		int i=3;
		Integer in=new Integer(i);
		int j=in.intValue();
		System.out.println("j="+j);
		String str=in.toString();
		System.out.println("str="+str);

		String str2="134";
		System.out.println(Integer.valueOf(str2));
	}
}




类Class
//ClassTest.java
public class ClassTest
{
	public static void main(String[] args)
	{
		Point pt=new Point();
		Class c1=pt.getClass();
		System.out.println(c1.getName());

		try
		{
			Class c2=Class.forName("Point");
			System.out.println(c2.getName());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		Class c3=Point.class;
		System.out.println(c3.getName());

		Class c4=int.class;
		System.out.println(c4.getName());

		Class c5=Integer.TYPE;
		System.out.println(c5.getName());

		Class c6=Integer.class;
		System.out.println(c6.getName());
	}
}

class Point
{
	int x,y;
}





//ClassTest.java
public class ClassTest
{
	public static void main(String[] args)
	{
		System.out.println( "Before new point" );
		new Point();
		System.out.println( "After new point" );


		try
		{
			Class c2=Class.forName("Line");
			System.out.println(c2.getName());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}

class Point
{
	static
	{
		System.out.println( "Loading Point...." );
	}
	int x,y;
}
class Line
{
	static
	{
		System.out.println( "Loading Line...." );
	}
}
//我们看看编译结果
E:\zieckey\Lesson6>javac ClassTest.java

E:\zieckey\Lesson6>java ClassTest
Before new point
Loading Point....
After new point
Loading Line....
Line
可可以看到只有在类被调用的时候，才执行static中的代码段

Class类
在运行期间，如果我们要产生某个类的对象，Java虚拟机(JVM)会检查该类型的Class对象是否已被加载。如果没有被加载，JVM会根据类的名称找到.class文件并加载它。一旦某个类型的Class对象已被加载到内存，就可以用它来产生该类型的所有对象。
newInstance() 调用类中缺省的构造方法。
//ClassTest.java
public class ClassTest
{
	public static void main(String[] args)
	{
		if(args.length!=1)
		{
			return;
		}
		try
		{
			Class c=Class.forName(args[0]);
			Point pt=(Point)c.newInstance();//创建一个c代表的类的实例
			pt.output();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			System.out.println( "Finish" );
		}
	}
}

class Point
{
	static
	{
		System.out.println( "Loading Point...." );
	}
	int x,y;
	void output()
	{
		System.out.println("x="+x+","+"y="+y);
	}
}
class Line
{
	static
	{
		System.out.println( "Loading Line...." );
	}
}

E:\zieckey\Lesson6>javac ClassTest.java

E:\zieckey\Lesson6>java ClassTest abc
java.lang.ClassNotFoundException: abc
        at java.net.URLClassLoader$1.run(URLClassLoader.java:200)
        at java.security.AccessController.doPrivileged(Native Method)
        at java.net.URLClassLoader.findClass(URLClassLoader.java:188)
        at java.lang.ClassLoader.loadClass(ClassLoader.java:306)
        at sun.misc.Launcher$AppClassLoader.loadClass(Launcher.java:268)
        at java.lang.ClassLoader.loadClass(ClassLoader.java:251)
        at java.lang.ClassLoader.loadClassInternal(ClassLoader.java:319)
        at java.lang.Class.forName0(Native Method)
        at java.lang.Class.forName(Class.java:164)
        at ClassTest.main(ClassTest.java:12)
Finish

E:\zieckey\Lesson6>java ClassTest Point
Loading Point....
x=0,y=0
Finish


//ClassTest.java
public class ClassTest
{
	public static void main(String[] args)
	{
		if(args.length!=1)
		{
			return;
		}
		try
		{
			Class c=Class.forName(args[0]);
			Point pt=(Point)c.newInstance();//创建一个c代表的类的实例
			pt.output();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			System.out.println( "Finish" );
		}
	}
}

class Point
{
	static
	{
		System.out.println( "Loading Point...." );
	}
	int x,y;
	void output()
	{
		System.out.println("x="+x+","+"y="+y);
	}
	Point(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
}
class Line
{
	static
	{
		System.out.println( "Loading Line...." );
	}
}
E:\zieckey\Lesson6>javac ClassTest.java

E:\zieckey\Lesson6>java ClassTest

E:\zieckey\Lesson6>java ClassTest Point
Loading Point....
java.lang.InstantiationException: Point
        at java.lang.Class.newInstance0(Class.java:335)
        at java.lang.Class.newInstance(Class.java:303)
        at ClassTest.main(ClassTest.java:13)
Finish
这里是因为，newInstance调用的是类的缺省构造函数，
但是我们的Point类已经提供了构造函数，如是在调用的时候就出错了。
那么我们如何解决呢？
//ClassTest.java
public class ClassTest
{
	public static void main(String[] args)
	{
		if(args.length!=1)
		{
			return;
		}
		try
		{
			Class c=Class.forName(args[0]);
			Constructor[] cons=c.getDeclaredConstructors();//得到构造函数数组
			for(int i=0;i<cons.length;i++)
			{
				System.out.println(cons[i]);
			}
			Method[] ms=c.getDeclaredMethods();//得到类的方法数组
			for(int i=0;i<ms.length;i++)
			{
				System.out.println(ms[i]);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			System.out.println( "Finish" );
		}
	}
}
E:\zieckey\Lesson6>javac ClassTest.java
ClassTest.java:13: 找不到符号
符号： 类 Constructor
位置： 类 ClassTest
                        Constructor[] cons=c.getDeclaredConstructors();//得到构
造函数数组
                        ^
ClassTest.java:18: 找不到符号
符号： 类 Method
位置： 类 ClassTest
                        Method[] ms=c.getDeclaredMethods();//得到类的方法数组
                        ^
2 错误

getDeclaredConstructors()是在java.lang.reflect包中定义的，所以要导入该包：


//ClassTest.java
import java.lang.reflect.*;
public class ClassTest
{
	public static void main(String[] args)
	{
		if(args.length!=1)
		{
			return;
		}
		try
		{
			Class c=Class.forName(args[0]);
			Constructor[] cons=c.getDeclaredConstructors();//得到构造函数数组
			for(int i=0;i<cons.length;i++)
			{
				System.out.println(cons[i]);
			}
			Method[] ms=c.getDeclaredMethods();//得到类的方法数组
			for(int i=0;i<ms.length;i++)
			{
				System.out.println(ms[i]);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			System.out.println( "Finish" );
		}
	}
}

class Point
{
	static
	{
		System.out.println( "Loading Point...." );
	}
	int x,y;
	void output()
	{
		System.out.println("x="+x+","+"y="+y);
	}
	void func()
	{
		System.out.println( "func....." );
	}

	Point(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
}
class Line
{
	static
	{
		System.out.println( "Loading Line...." );
	}
}

E:\zieckey\Lesson6>javac ClassTest.java

E:\zieckey\Lesson6>java ClassTest Point
Loading Point....
Point(int,int)
void Point.func()
void Point.output()
Finish

E:\zieckey\Lesson6>java abv
Exception in thread "main" java.lang.NoClassDefFoundError: abv

E:\zieckey\Lesson6>java ClassTest jdaj
java.lang.ClassNotFoundException: jdaj
        at java.net.URLClassLoader$1.run(URLClassLoader.java:200)
        at java.security.AccessController.doPrivileged(Native Method)
        at java.net.URLClassLoader.findClass(URLClassLoader.java:188)
        at java.lang.ClassLoader.loadClass(ClassLoader.java:306)
        at sun.misc.Launcher$AppClassLoader.loadClass(Launcher.java:268)
        at java.lang.ClassLoader.loadClass(ClassLoader.java:251)
        at java.lang.ClassLoader.loadClassInternal(ClassLoader.java:319)
        at java.lang.Class.forName0(Native Method)
        at java.lang.Class.forName(Class.java:164)
        at ClassTest.main(ClassTest.java:13)
Finish

下面看看怎么动态调用一个不知名的类对象的成员方法,通过反射来实现
//ClassTest.java
import java.lang.reflect.*;
public class ClassTest
{
	public static void main(String[] args)
	{
		if(args.length!=1)
		{
			return;
		}
		try
		{
			Class c=Class.forName(args[0]);
			Constructor[] cons=c.getDeclaredConstructors();//得到构造函数数组
			Class[] params=cons[0].getParameterTypes();
			Object[] paramValues=new Object[params.length];
			for(int i=0;i<params.length;i++)
			{
				if(params[i].isPrimitive())
				{
					paramValues[i]=new Integer(i+3);
				}
			}
			Object o=cons[0].newInstance(paramValues);
			Method[] ms=c.getDeclaredMethods();
			ms[0].invoke(o);

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			System.out.println( "Finish" );
		}
	}
}

class Point
{
	static
	{
		System.out.println( "Loading Point...." );
	}
	int x,y;
	void output()
	{
		System.out.println("x="+x+","+"y="+y);
	}
	Point(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
}
class Line
{
	static
	{
		System.out.println( "Loading Line...." );
	}
}

E:\zieckey\Lesson6>javac ClassTest.java

E:\zieckey\Lesson6>java ClassTest

E:\zieckey\Lesson6>java ClassTest Point
Loading Point....
x=3,y=4
Finish


Runtime类和Process类
每一个Java程序都有一个Runtime类的单一实例，
这个实例可以得到运行该程序的环境的一些环境信息，例如内存使用量等等，
它提供了应用程序和环境之间的接口。
通过Runtime.getRuntime()获取Runtime类的实例。
Runtime类是使用单例模式的一个例子。


//RuntimeTest.java
class RuntimeTest
{
	public static void main(String[] args)
	{
		Runtime rt=Runtime.getRuntime();
		System.out.println( "freeMemory:" + rt.freeMemory());
		System.out.println( "totalMemory:" + rt.totalMemory());
	}
}
E:\zieckey\Lesson6>javac RuntimeTest.java

E:\zieckey\Lesson6>java RuntimeTest
freeMemory:1836224
totalMemory:2031616

这个Runtime类还可以执行一个外部的程序，例如：
//RuntimeTest.java
class RuntimeTest
{
	public static void main(String[] args)
	{
		Runtime rt=Runtime.getRuntime();
		try
		{
			rt.exec("notepad");
			System.out.println("Notepad is running...");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}
}
E:\zieckey\Lesson6>javac RuntimeTest.java

E:\zieckey\Lesson6>java RuntimeTest
Notepad is running...
这个时候，记事本程序已经运行起来了

//RuntimeTest.java
import java.io.*;
class RuntimeTest
{
	public static void main(String[] args)
	{

		try
		{
			Runtime rt1=Runtime.getRuntime();
			rt1.exec("javac Test.java");	//编译
			Runtime rt2=Runtime.getRuntime();
			Process p = rt2.exec("java Test");	//运行，
			InputStream is=p.getInputStream();//获取到运行"java Test"程序的输出数据
			int data;
			while((data=is.read())!=-1)
			{
				System.out.print((char)data);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}

E:\zieckey\Lesson6>javac RuntimeTest.java

E:\zieckey\Lesson6>java RuntimeTest
j=3
str=3
134

E:\zieckey\Lesson6>java Test
j=3
str=3
134

可以看到我们还可以在此编译程序，然后运行程序，并将打印信息打印出来。
者和单独运行Test.java程序一样


设计模式
在我们进行程序设计时，逐渐形成了一些典型问题和问题的解决方案，这就是软件模式。
每一个模式描述了一个在我们程序设计中经常发生的问题，以及该问题的解决方案。
当我们碰到模式所描述的问题，就可以直接用相应的解决方法去解决这个问题，这就是设计模式。

单例（Singleton）模式
   （1）一个类只有一个实例，而且自行实例化并向整个系统提供这个实例，这个类称为单例类。
   （2）单例类的一个最重要的特点是类的构造方法是私有的，从而避免了外部利用构造方法直接创建多个实例。
class Singleton
{
	private static final Singleton st=new Singleton();
	private Singleton(){}
	public static Singleton getInstance()
	{
		return st;
	}
}

设计模式参考书籍：
《 Java与模式》
  作者：阎宏
  电子工业出版社出版


Lesson7
多线程

程序、进程和线程
	程序是计算机指令的集合，它以文件的形式存储在磁盘上。
	进程：是一个程序在其自身的地址空间中的一次执行活动。
	进程是资源申请、调度和独立运行的单位，因此，它使用系统中的运行资源；
而程序不能申请系统资源，不能被系统调度，也不能作为独立运行的单位，
因此，它不占用系统的运行资源。
	线程：是进程中的一个单一的连续控制流程。一个进程可以拥有多个线程。
线程又称为轻量级进程，它和进程一样拥有独立的执行控制，
由操作系统负责调度，区别在于线程没有独立的存储空间，
而是和所属进程中的其它线程共享一个存储空间，这使得线程间的通信远较进程简单。

Java对多线程的支持
Java在语言级提供了对多线程程序设计的支持。
实现多线程程序的两种方式：
    （1）从Thread类继承；
    （2）实现Runnable接口。
Java运行时系统实现了一个用于调度线程执行的线程调度器，用于确定某一时刻由哪一个线程在CPU上运行。
在java技术中，线程通常是抢占式的而不需要时间片分配进程（分配给每个线程相等的CPU时间的进程）。抢占式调度模型就是许多线程处于可以运行状态（等待状态），但实际上只有一个线程在运行。该线程一直运行到它终止进入可运行状态（等待状态），或者另一个具有更高优先级的线程变成可运行状态。在后一种情况下，低优先级的线程被高优先级的线程抢占，高优先级的线程获得运行的机会。
Java线程调度器支持不同优先级线程的抢先方式，但其本身不支持相同优先级线程的时间片轮换。
Java运行时系统所在的操作系统（例如：Windows2000）支持时间片的轮换，则线程调度器就支持相同优先级线程的时间片轮换。
There are two ways to create a new thread of execution. One is to declare a class to be a subclass of Thread. This subclass should override the run method of class Thread. An instance of the subclass can then be allocated and started. For example, a thread that computes primes larger than a stated value could be written as follows:



--------------------------------------------------------------------------------

     class PrimeThread extends Thread {
         long minPrime;
         PrimeThread(long minPrime) {
             this.minPrime = minPrime;
         }

         public void run() {
             // compute primes larger than minPrime
              . . .
         }
     }

--------------------------------------------------------------------------------

The following code would then create a thread and start it running:


     PrimeThread p = new PrimeThread(143);
     p.start();
 The other way to create a thread is to declare a class that implements the Runnable interface. That class then implements the run method. An instance of the class can then be allocated, passed as an argument when creating Thread, and started. The same example in this other style looks like the following:



--------------------------------------------------------------------------------

     class PrimeRun implements Runnable {
         long minPrime;
         PrimeRun(long minPrime) {
             this.minPrime = minPrime;
         }

         public void run() {
             // compute primes larger than minPrime
              . . .
         }
     }

--------------------------------------------------------------------------------

The following code would then create a thread and start it running:


     PrimeRun p = new PrimeRun(143);
     new Thread(p).start();
 Every thread has a name for identification purposes. More than one thread may have the same name. If a name is not specified when a thread is created, a new name is generated for it.





//MutiThread.java
class MutiThread
{
	public static void main( String[]args )
	{
		MyThread mt=new MyThread();//创建一个线程
		mt.start();//让线程开始运行
		System.out.println("main:"+Thread.currentThread().getName());
	}
}

class MyThread extends Thread//定义一个线程
{
	public void run()
	{
		System.out.println( getName() );
	}
}
E:\zieckey\Lesson7>javac MutiThread.java

E:\zieckey\Lesson7>java MutiThread
main:main
Thread-0

Thread-0这个是jvm给我们分配的一个名字
这里应该看看是先打印main方法的线程名字，后面才打印我们自定义的线程。

我们让线程循环来看看CPU在两个线程之间的切换：
//MutiThread.java
class MutiThread
{
	public static void main( String[]args )
	{
		MyThread mt=new MyThread();//创建一个线程
		mt.start();//让线程开始运行
		while ( true )
		{
			System.out.println("main:"+Thread.currentThread().getName());
		}
	}
}

class MyThread extends Thread//定义一个线程
{
	public void run()
	{
		while ( true )
		{
			System.out.println( getName() );
		}
	}
}
E:\zieckey\Lesson7>javac MutiThread.java

E:\zieckey\Lesson7>java MutiThread
main:main
main:main
main:main
main:main
main:main
main:main
main:main
main:main
main:main
main:main
main:main
main:main
main:main
main:main
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
main:main
main:main
main:main
main:main
main:main
main:main
main:main
main:main
main:main
main:main
main:main
main:main
main:main
main:main
main:main
main:main
main:main
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
main:main
main:main
main:main
main:main
main:main
main:main
main:main
main:main
main:main
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
main:main
main:main
main:main
main:main
main:main
main:main
main:main
main:main
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
main:main
main:main
main:main
main:main
main:main
main:main
main:main
main:main
main:main
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
main:main
main:main
main:main
main:main
main:main
main:main
main:main
main:main
main:main
main:main
main:main
main:main
main:main
......


设置后台线程：setDaemon
//MutiThread.java
class MutiThread
{
	public static void main( String[]args )
	{
		MyThread mt=new MyThread();//创建一个线程
		mt.setDaemon(true);//设置后台线程,这个必须在线程启动之前定义
		mt.start();//让线程开始运行
		int i=0;
		while ( true )
		{
			if ( i++ == 5 )
				break;
			System.out.println("main:"+Thread.currentThread().getName());
		}
	}
}

class MyThread extends Thread//定义一个线程
{
	public void run()
	{
		while ( true )
		{
			System.out.println( getName() );
		}
	}
}

E:\zieckey\Lesson7>javac MutiThread.java

E:\zieckey\Lesson7>java MutiThread
main:main
main:main
main:main
main:main
main:main
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
这里就可以看当main方法结束后，后台线程也结束了。

另外可以通过yield();方法使线程放弃执行而让其他线程执行：
//MutiThread.java
class MutiThread
{
	public static void main( String[]args )
	{
		MyThread mt=new MyThread();//创建一个线程
		mt.setDaemon(true);//设置后台线程,这个必须在线程启动之前定义
		mt.start();//让线程开始运行
		int i=0;
		while ( true )
		{
			if ( i++ == 500 )
				break;
			System.out.println("main:"+Thread.currentThread().getName());
		}
	}
}

class MyThread extends Thread//定义一个线程
{
	public void run()
	{
		while ( true )
		{
			System.out.println( getName() );
			yield();
		}
	}
}
E:\zieckey\Lesson7>javac MutiThread.java

E:\zieckey\Lesson7>java MutiThread
main:main
main:main
main:main
main:main
main:main
main:main
main:main
main:main
main:main
Thread-0
main:main
main:main
main:main
main:main
main:main
main:main
main:main
main:main
main:main
Thread-0
main:main
main:main
main:main
main:main
main:main
main:main
main:main
main:main
main:main
Thread-0
main:main
main:main
main:main
main:main
main:main
main:main
main:main
main:main
main:main
Thread-0
main:main
main:main
main:main
main:main
main:main
main:main
main:main
main:main
main:main
Thread-0
main:main
main:main
main:main
main:main
main:main
main:main
main:main
这里看以看到每当MyThread执行一次，它打印完名字后，它就停止执行了，
然后CPU转向main线程，当main线程的时间片用完后，有回到MyThread

线程还可以设置优先级：setPriority( int )         getPriority
//MutiThread.java
class MutiThread
{
	public static void main( String[]args )
	{
		MyThread mt=new MyThread();//创建一个线程
		mt.start();//让线程开始运行
		mt.setPriority(Thread.MAX_PRIORITY);
		int i=0;
		while ( true )
		{
			if ( i++ == 5000 )
				break;
			System.out.println("main:"+Thread.currentThread().getName());
		}
	}
}

class MyThread extends Thread//定义一个线程
{
	public void run()
	{
		while ( true )
		{
			System.out.println( getName() );
			yield();
		}
	}
}
E:\zieckey\Lesson7>javac MutiThread.java

E:\zieckey\Lesson7>java MutiThread
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
main:main
main:main
main:main
main:main

这里可以看到高优先级的 MyThread 线程始终获得CPU的执行，只有当我们用户终止的时候，
main线程才获得一会儿CPU执行。

Java运行时系统实现了一个用于调度线程执行的线程调度器，
用于确定某一时刻由哪一个线程在CPU上运行。
在java技术中，线程通常是抢占式的而不需要时间片分配进程
（分配给每个线程相等的CPU时间的进程）。
抢占式调度模型就是许多线程处于可以运行状态（等待状态），
但实际上只有一个线程在运行。该线程一直运行到它终止进入可运行状态（等待状态），
或者另一个具有更高优先级的线程变成可运行状态。在后一种情况下，
低优先级的线程被高优先级的线程抢占，高优先级的线程获得运行的机会。
Java线程调度器支持不同优先级线程的抢先方式，
但其本身不支持相同优先级线程的时间片轮换。
Java运行时系统所在的操作系统（例如：Windows2000）支持时间片的轮换，
则线程调度器就支持相同优先级线程的时间片轮换。

上面是通过继承Thread类来创建线程，
下面我们看看如何通过实现Runnable接口来创建线程。
//MutiThread.java
class MutiThread
{
	public static void main( String[]args )
	{
		MyThread mt=new MyThread();//创建一个线程
		new Thread( mt ).start();
		int i=0;
		while ( true )
		{
			if ( i++ == 5000 )
				break;
			System.out.println( "main:"+Thread.currentThread().getName() );
		}
	}
}

class MyThread implements Runnable//extends Thread//定义一个线程
{
	public void run()
	{
		while ( true )
		{
			System.out.println( Thread.currentThread().getName() );
		}
	}
}
E:\zieckey\Lesson7>javac MutiThread.java

E:\zieckey\Lesson7>java MutiThread
main:main
main:main
main:main
main:main
main:main
main:main
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
main:main
main:main
main:main
main:main

实现Runnable接口来创建线程的优点：
（1）可以同时从另外的一个类继承来
（2）可以很方便的实现内存的共享，例如：
//MutiThread.java
class MutiThread
{
	public static void main( String[]args )
	{
		MyThread mt=new MyThread();//创建一个线程
		new Thread(mt).start();
		new Thread(mt).start();
		new Thread(mt).start();
		new Thread(mt).start();
		new Thread(mt).start();
		new Thread(mt).start();
		new Thread(mt).start();
		new Thread(mt).start();
		int i=0;
		while ( true )
		{
			if ( i++ == 5000 )
				break;
			System.out.println( "main:"+Thread.currentThread().getName() );
		}
	}
}

class MyThread implements Runnable//extends Thread//定义一个线程
{
	int index=0;
	public void run()
	{
		while ( true )
		{
			System.out.println( Thread.currentThread().getName() + ":" + index++ );
		}
	}
}
E:\zieckey\Lesson7>javac MutiThread.java

E:\zieckey\Lesson7>java MutiThread
main:main
main:main
main:main
Thread-0:0
Thread-1:1
Thread-2:2
Thread-3:3
Thread-4:4
Thread-5:5
Thread-6:6
Thread-7:7
Thread-0:8
Thread-1:9
Thread-2:10
Thread-3:11
Thread-4:12
Thread-5:13
Thread-6:14
Thread-7:15
Thread-0:16
Thread-1:17
Thread-2:18
Thread-3:19
Thread-4:20
Thread-5:21
Thread-6:22
Thread-7:23
Thread-0:24
Thread-1:25
Thread-2:26
Thread-3:27
Thread-4:28
Thread-5:29
Thread-6:30
Thread-7:31
Thread-0:32
Thread-1:33
Thread-2:34
Thread-3:35
Thread-4:36
Thread-5:37
Thread-6:38
Thread-7:39
Thread-0:40
Thread-1:41
Thread-2:42
Thread-3:43
Thread-4:44
Thread-5:45
Thread-6:46
Thread-7:47
main:main
Thread-0:48
Thread-1:49
Thread-2:50
Thread-3:51
Thread-4:52
Thread-5:53
Thread-6:54
main:main
Thread-0:55
Thread-1:56
Thread-2:57

上面说的两种优点都可以通过内部类实现：
//MutiThread.java
class MutiThread
{
	public static void main( String[]args )
	{
		MyThread mt=new MyThread();//创建一个线程
		mt.getThread().start();
		mt.getThread().start();
		mt.getThread().start();
		mt.getThread().start();
		mt.getThread().start();
		int i=0;
		while ( true )
		{
			if ( i++ == 5000 )
				break;
			System.out.println( "main:"+Thread.currentThread().getName() );
		}
	}
}

class MyThread //implements Runnable//extends Thread//定义一个线程
{
	int index=0;
	private class InnerThread extends Thread//这个定义为private是为了隐藏实现细节
	{
		public void run()
		{
			while ( true )
			{
				System.out.println( Thread.currentThread().getName() + ":" + index++ );
			}
		}
	}
	Thread getThread()
	{
		return new InnerThread();
	}


}
E:\zieckey\Lesson7>javac MutiThread.java

E:\zieckey\Lesson7>java MutiThread
main:main
main:main
main:main
main:main
Thread-0:0
Thread-1:1
Thread-2:2
Thread-3:3
Thread-4:4
Thread-0:5
Thread-1:6
Thread-2:7
Thread-3:8
Thread-4:9
Thread-0:10
Thread-1:11
Thread-2:12
Thread-3:13
Thread-4:14
Thread-0:15
Thread-1:16
Thread-2:17
Thread-3:18
Thread-4:19
Thread-0:20
Thread-1:21
Thread-2:22
Thread-3:23
Thread-4:24
Thread-0:25
Thread-1:26
Thread-2:27
Thread-3:28
Thread-4:29
main:main
Thread-0:30
Thread-1:31
Thread-2:32
Thread-3:33
main:main
Thread-0:34
Thread-1:35
Thread-2:36
Thread-3:37
main:main
Thread-0:38
Thread-1:39
Thread-2:40
Thread-3:41
main:main
Thread-0:42
Thread-1:43
Thread-2:44
Thread-3:45
main:main
Thread-0:46
Thread-1:47
Thread-2:48
Thread-3:49
main:main
Thread-0:50
Thread-1:51
Thread-2:52
Thread-3:53
main:main
Thread-4:54
Thread-0:55
Thread-1:56
Thread-2:57
main:main
Thread-4:58


下面看看一个模拟的售票系统
//TicketsSystem.java
class TicketsSystem
{
	public static void main(String[] args)
	{
		SellThread st=new SellThread();
		new Thread(st).start();
		new Thread(st).start();
		new Thread(st).start();
		new Thread(st).start();
	}
}
class SellThread implements Runnable
{
	int tickets=100;
	public void run()
	{
		while ( true )
		{
			if ( tickets > 0 )
			{
				System.out.println( Thread.currentThread().getName() +
								"Sell tickets : " + tickets );
				tickets --;
			}
		}
	}

}
E:\zieckey\Lesson7>javac TicketsSystem.java
E:\zieckey\Lesson7>java TicketsSystem
Thread-0Sell tickets : 100
Thread-0Sell tickets : 99
Thread-0Sell tickets : 98
Thread-0Sell tickets : 97
Thread-0Sell tickets : 96
Thread-0Sell tickets : 95
Thread-0Sell tickets : 94
Thread-1Sell tickets : 94
Thread-2Sell tickets : 94
Thread-3Sell tickets : 94
Thread-1Sell tickets : 93
Thread-2Sell tickets : 92
Thread-3Sell tickets : 91
Thread-1Sell tickets : 90
Thread-2Sell tickets : 89
Thread-3Sell tickets : 88
Thread-1Sell tickets : 87
Thread-2Sell tickets : 86
Thread-3Sell tickets : 85

但是这个程序有点问题，就是可能售出0，-1等这样的票，我们看看：
//TicketsSystem.java
class TicketsSystem
{
	public static void main(String[] args)
	{
		SellThread st=new SellThread();
		new Thread(st).start();
		new Thread(st).start();
		new Thread(st).start();
		new Thread(st).start();
	}
}
class SellThread implements Runnable
{
	int tickets=100;
	public void run()
	{
		while ( true )
		{
			if ( tickets > 0 )
			{
				try
				{
					Thread.sleep( 10 );
				}
				catch( Exception e )
				{
					e.printStackTrace();
				}

				System.out.println( Thread.currentThread().getName() +
								"Sell tickets : " + tickets );
				tickets --;
			}
		}
	}

}
E:\zieckey\Lesson7>javac TicketsSystem.java

E:\zieckey\Lesson7>java TicketsSystem
Thread-0Sell tickets : 100
Thread-1Sell tickets : 99
Thread-2Sell tickets : 98
Thread-3Sell tickets : 97
Thread-0Sell tickets : 96
Thread-1Sell tickets : 95
Thread-2Sell tickets : 94
Thread-3Sell tickets : 93
Thread-0Sell tickets : 92
Thread-1Sell tickets : 91
Thread-2Sell tickets : 90
Thread-3Sell tickets : 89
Thread-0Sell tickets : 88
Thread-1Sell tickets : 87
Thread-2Sell tickets : 86
Thread-3Sell tickets : 85
Thread-0Sell tickets : 84
Thread-1Sell tickets : 83
Thread-2Sell tickets : 82
Thread-3Sell tickets : 81
Thread-0Sell tickets : 80
Thread-1Sell tickets : 79
Thread-2Sell tickets : 78
Thread-3Sell tickets : 77
Thread-0Sell tickets : 76
Thread-1Sell tickets : 75
Thread-2Sell tickets : 74
Thread-3Sell tickets : 73
Thread-0Sell tickets : 72
Thread-1Sell tickets : 71
Thread-2Sell tickets : 70
Thread-3Sell tickets : 69
Thread-0Sell tickets : 68
Thread-1Sell tickets : 67
Thread-2Sell tickets : 66
Thread-3Sell tickets : 65
Thread-0Sell tickets : 64
Thread-1Sell tickets : 63
Thread-2Sell tickets : 62
Thread-3Sell tickets : 61
Thread-0Sell tickets : 60
Thread-1Sell tickets : 59
Thread-2Sell tickets : 59
Thread-3Sell tickets : 59
Thread-0Sell tickets : 59
Thread-0Sell tickets : 55
Thread-3Sell tickets : 54
Thread-2Sell tickets : 53
Thread-1Sell tickets : 52
Thread-0Sell tickets : 51
Thread-3Sell tickets : 50
Thread-2Sell tickets : 49
Thread-1Sell tickets : 48
Thread-0Sell tickets : 47
Thread-3Sell tickets : 46
Thread-2Sell tickets : 45
Thread-1Sell tickets : 44
Thread-0Sell tickets : 43
Thread-3Sell tickets : 42
Thread-2Sell tickets : 41
Thread-1Sell tickets : 40
Thread-0Sell tickets : 39
Thread-3Sell tickets : 38
Thread-2Sell tickets : 37
Thread-1Sell tickets : 36
Thread-0Sell tickets : 35
Thread-3Sell tickets : 34
Thread-2Sell tickets : 34
Thread-1Sell tickets : 34
Thread-0Sell tickets : 31
Thread-2Sell tickets : 30
Thread-3Sell tickets : 29
Thread-1Sell tickets : 28
Thread-0Sell tickets : 27
Thread-2Sell tickets : 26
Thread-3Sell tickets : 25
Thread-1Sell tickets : 24
Thread-0Sell tickets : 23
Thread-2Sell tickets : 22
Thread-3Sell tickets : 21
Thread-1Sell tickets : 20
Thread-0Sell tickets : 19
Thread-2Sell tickets : 18
Thread-3Sell tickets : 17
Thread-1Sell tickets : 16
Thread-0Sell tickets : 15
Thread-2Sell tickets : 14
Thread-3Sell tickets : 13
Thread-1Sell tickets : 12
Thread-0Sell tickets : 11
Thread-2Sell tickets : 10
Thread-3Sell tickets : 10
Thread-1Sell tickets : 10
Thread-0Sell tickets : 7
Thread-1Sell tickets : 6
Thread-3Sell tickets : 5
Thread-2Sell tickets : 4
Thread-0Sell tickets : 3
Thread-1Sell tickets : 2
Thread-3Sell tickets : 1
Thread-1Sell tickets : 0
Thread-2Sell tickets : -1
Thread-0Sell tickets : -2
这个结果显然是不对的，那么我如何解决呢？
这就要用到线程的同步机制。

线程的同步
The code segments within a program that access the same object from separate, concurrent threads are called “critical sections”。
同步的两种方式：同步块和同步方法
每一个对象都有一个监视器，或者叫做锁。
同步方法利用的是this所代表的对象的锁。
每个class也有一个锁，是这个class所对应的Class对象的锁。


同步块的方法：
//TicketsSystem.java
class TicketsSystem
{
	public static void main(String[] args)
	{
		SellThread st=new SellThread();
		new Thread(st).start();
		new Thread(st).start();
		new Thread(st).start();
		new Thread(st).start();
	}
}
class SellThread implements Runnable
{
	int tickets=100;
	//Object obj = new Object();
	int criticalSections = 0;
	public void run()
	{
		while ( true )
		{
			//synchronized( obj )//这里就是同步块
			synchronized( criticalSections )//这里就是同步块
			{
				if ( tickets > 0 )
				{
					try
					{
						Thread.sleep( 10 );
					}
					catch( Exception e )
					{
						e.printStackTrace();
					}

					System.out.println( Thread.currentThread().getName() +
									"Sell tickets : " + tickets );
					tickets --;
				}
			}
		}
	}

}
E:\zieckey\Lesson7>javac TicketsSystem.java

E:\zieckey\Lesson7>java TicketsSystem
Thread-0Sell tickets : 100
Thread-1Sell tickets : 99
Thread-2Sell tickets : 98
Thread-3Sell tickets : 97
Thread-0Sell tickets : 96
Thread-1Sell tickets : 95
Thread-2Sell tickets : 94
Thread-3Sell tickets : 93
Thread-0Sell tickets : 92
Thread-1Sell tickets : 91
Thread-2Sell tickets : 90
Thread-3Sell tickets : 89
Thread-0Sell tickets : 88
Thread-1Sell tickets : 87
Thread-2Sell tickets : 86
Thread-3Sell tickets : 85
Thread-0Sell tickets : 84
Thread-1Sell tickets : 83
Thread-2Sell tickets : 82
Thread-3Sell tickets : 81
Thread-0Sell tickets : 80
Thread-1Sell tickets : 79
Thread-2Sell tickets : 78
Thread-3Sell tickets : 77
Thread-0Sell tickets : 76
Thread-1Sell tickets : 75
Thread-2Sell tickets : 74
Thread-3Sell tickets : 73
Thread-0Sell tickets : 72
Thread-1Sell tickets : 71
Thread-2Sell tickets : 70
Thread-3Sell tickets : 69
Thread-0Sell tickets : 68
Thread-1Sell tickets : 67
Thread-2Sell tickets : 66
Thread-3Sell tickets : 65
Thread-0Sell tickets : 64
Thread-1Sell tickets : 63
Thread-2Sell tickets : 62
Thread-3Sell tickets : 61
Thread-0Sell tickets : 60
Thread-1Sell tickets : 59
Thread-2Sell tickets : 58
Thread-3Sell tickets : 57
Thread-0Sell tickets : 56
Thread-1Sell tickets : 55
Thread-2Sell tickets : 54
Thread-3Sell tickets : 53
Thread-0Sell tickets : 52
Thread-1Sell tickets : 51
Thread-2Sell tickets : 50
Thread-3Sell tickets : 49
Thread-0Sell tickets : 48
Thread-1Sell tickets : 47
Thread-2Sell tickets : 46
Thread-3Sell tickets : 45
Thread-0Sell tickets : 44
Thread-1Sell tickets : 43
Thread-2Sell tickets : 42
Thread-3Sell tickets : 41
Thread-0Sell tickets : 40
Thread-1Sell tickets : 39
Thread-2Sell tickets : 38
Thread-3Sell tickets : 37
Thread-0Sell tickets : 36
Thread-1Sell tickets : 35
Thread-2Sell tickets : 34
Thread-3Sell tickets : 33
Thread-0Sell tickets : 32
Thread-1Sell tickets : 31
Thread-2Sell tickets : 30
Thread-3Sell tickets : 29
Thread-0Sell tickets : 28
Thread-1Sell tickets : 27
Thread-2Sell tickets : 26
Thread-3Sell tickets : 25
Thread-0Sell tickets : 24
Thread-1Sell tickets : 23
Thread-2Sell tickets : 22
Thread-3Sell tickets : 21
Thread-0Sell tickets : 20
Thread-1Sell tickets : 19
Thread-2Sell tickets : 18
Thread-3Sell tickets : 17
Thread-0Sell tickets : 16
Thread-1Sell tickets : 15
Thread-2Sell tickets : 14
Thread-3Sell tickets : 13
Thread-0Sell tickets : 12
Thread-1Sell tickets : 11
Thread-2Sell tickets : 10
Thread-3Sell tickets : 9
Thread-0Sell tickets : 8
Thread-1Sell tickets : 7
Thread-2Sell tickets : 6
Thread-3Sell tickets : 5
Thread-0Sell tickets : 4
Thread-1Sell tickets : 3
Thread-2Sell tickets : 2
Thread-3Sell tickets : 1
这就不可能出现上面的错误售票了。
	synchronized( obj )//这里就是同步块
这句话是对obj对象加锁，以实现同步。

同步方法的实现：
//TicketsSystem.java
class TicketsSystem
{
	public static void main(String[] args)
	{
		SellThread st=new SellThread();
		new Thread(st).start();
		new Thread(st).start();
		new Thread(st).start();
		new Thread(st).start();
	}
}
class SellThread implements Runnable
{
	int tickets=100;
	Object obj = new Object();
	public void run()
	{
		while ( true )
		{
			/*synchronized( obj )//这里就是同步块
			{
				if ( tickets > 0 )
				{
					try
					{
						Thread.sleep( 10 );
					}
					catch( Exception e )
					{
						e.printStackTrace();
					}

					System.out.println( Thread.currentThread().getName() +
									"Sell tickets : " + tickets );
					tickets --;
				}
			}*/
			sell();
		}
	}
	public synchronized void sell() //同步的方法就是在方法前面加上修饰符synchronized
	{
		synchronized(obj)
		{
			if(tickets>0)
			{
				try
				{
					Thread.sleep(10);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				System.out.println("sell():"+Thread.currentThread().getName()+
						" sell tickets:"+tickets);
				tickets--;
			}
		}
	}
}
E:\zieckey\Lesson7>javac TicketsSystem.java

E:\zieckey\Lesson7>java TicketsSystem
sell():Thread-0 sell tickets:100
sell():Thread-1 sell tickets:99
sell():Thread-2 sell tickets:98
sell():Thread-3 sell tickets:97
sell():Thread-0 sell tickets:96
sell():Thread-1 sell tickets:95
sell():Thread-2 sell tickets:94
sell():Thread-3 sell tickets:93
sell():Thread-0 sell tickets:92
sell():Thread-1 sell tickets:91
sell():Thread-2 sell tickets:90
sell():Thread-3 sell tickets:89
sell():Thread-0 sell tickets:88
sell():Thread-1 sell tickets:87
sell():Thread-2 sell tickets:86
sell():Thread-3 sell tickets:85
sell():Thread-0 sell tickets:84
sell():Thread-1 sell tickets:83
sell():Thread-2 sell tickets:82
sell():Thread-3 sell tickets:81
sell():Thread-0 sell tickets:80
sell():Thread-1 sell tickets:79
sell():Thread-2 sell tickets:78
sell():Thread-3 sell tickets:77
sell():Thread-0 sell tickets:76
sell():Thread-1 sell tickets:75
sell():Thread-2 sell tickets:74
sell():Thread-3 sell tickets:73
sell():Thread-0 sell tickets:72
sell():Thread-1 sell tickets:71
sell():Thread-2 sell tickets:70
sell():Thread-3 sell tickets:69
sell():Thread-0 sell tickets:68
sell():Thread-1 sell tickets:67
sell():Thread-2 sell tickets:66
sell():Thread-3 sell tickets:65
sell():Thread-0 sell tickets:64
sell():Thread-1 sell tickets:63
sell():Thread-2 sell tickets:62
sell():Thread-3 sell tickets:61
sell():Thread-0 sell tickets:60
sell():Thread-1 sell tickets:59
sell():Thread-2 sell tickets:58
sell():Thread-3 sell tickets:57
sell():Thread-0 sell tickets:56
sell():Thread-1 sell tickets:55
sell():Thread-2 sell tickets:54
sell():Thread-3 sell tickets:53
sell():Thread-0 sell tickets:52
sell():Thread-1 sell tickets:51
sell():Thread-2 sell tickets:50
sell():Thread-3 sell tickets:49
sell():Thread-0 sell tickets:48
sell():Thread-1 sell tickets:47
sell():Thread-2 sell tickets:46
sell():Thread-3 sell tickets:45
sell():Thread-0 sell tickets:44
sell():Thread-1 sell tickets:43
sell():Thread-2 sell tickets:42
sell():Thread-3 sell tickets:41
sell():Thread-0 sell tickets:40
sell():Thread-1 sell tickets:39
sell():Thread-2 sell tickets:38
sell():Thread-3 sell tickets:37
sell():Thread-0 sell tickets:36
sell():Thread-1 sell tickets:35
sell():Thread-2 sell tickets:34
sell():Thread-3 sell tickets:33
sell():Thread-0 sell tickets:32
sell():Thread-1 sell tickets:31
sell():Thread-2 sell tickets:30
sell():Thread-3 sell tickets:29
sell():Thread-0 sell tickets:28
sell():Thread-1 sell tickets:27
sell():Thread-2 sell tickets:26
sell():Thread-3 sell tickets:25
sell():Thread-0 sell tickets:24
sell():Thread-1 sell tickets:23
sell():Thread-2 sell tickets:22
sell():Thread-3 sell tickets:21
sell():Thread-0 sell tickets:20
sell():Thread-1 sell tickets:19
sell():Thread-2 sell tickets:18
sell():Thread-3 sell tickets:17
sell():Thread-0 sell tickets:16
sell():Thread-1 sell tickets:15
sell():Thread-2 sell tickets:14
sell():Thread-3 sell tickets:13
sell():Thread-0 sell tickets:12
sell():Thread-1 sell tickets:11
sell():Thread-2 sell tickets:10
sell():Thread-3 sell tickets:9
sell():Thread-0 sell tickets:8
sell():Thread-1 sell tickets:7
sell():Thread-2 sell tickets:6
sell():Thread-3 sell tickets:5
sell():Thread-0 sell tickets:4
sell():Thread-1 sell tickets:3
sell():Thread-2 sell tickets:2
sell():Thread-3 sell tickets:1
这里的实对 this 对象加锁，下面我们做一个测试，看看如果同步块也对 this 加锁，
那么同步块和同步方法是否同步？

//TicketsSystem.java
class TicketsSystem
{
	public static void main(String[] args)
	{
		SellThread st=new SellThread();
		new Thread(st).start();
		try
		{
			Thread.sleep(1);//这里等待1ms是为了让第一个线程启动起来，
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		st.b = true ;//第一个线程已经启动之后才设置st.b = true
		new Thread(st).start();

	}
}
class SellThread implements Runnable
{
	int tickets=100;
	Object obj = new Object();
	boolean b = false ;
	public void run()
	{
		if ( b == false )
		{
			while ( true )
			{
				sell();
			}

		}
		else
		{
			while ( true )
			{
				synchronized( obj )//这里就是同步块
				{
					if ( tickets > 0 )
					{
						try
						{
							Thread.sleep( 10 );
						}
						catch( Exception e )
						{
							e.printStackTrace();
						}

						System.out.println( Thread.currentThread().getName() +
										"Sell tickets : " + tickets );
						tickets --;
					}
				}
			}
		}

	}
	public synchronized void sell()
	{

		if(tickets>0)
		{
			try
			{
				Thread.sleep(10);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			System.out.println("sell():"+Thread.currentThread().getName()+
					" sell tickets:"+tickets);
			tickets--;
		}
	}
}
E:\zieckey\Lesson7>javac TicketsSystem.java

E:\zieckey\Lesson7>java TicketsSystem
sell():Thread-0 sell tickets:100
Thread-1Sell tickets : 99
sell():Thread-0 sell tickets:98
Thread-1Sell tickets : 97
sell():Thread-0 sell tickets:96
Thread-1Sell tickets : 95
sell():Thread-0 sell tickets:94
Thread-1Sell tickets : 93
sell():Thread-0 sell tickets:92
Thread-1Sell tickets : 91
sell():Thread-0 sell tickets:90
Thread-1Sell tickets : 89
sell():Thread-0 sell tickets:88
Thread-1Sell tickets : 87
sell():Thread-0 sell tickets:86
Thread-1Sell tickets : 85
sell():Thread-0 sell tickets:84
Thread-1Sell tickets : 83
sell():Thread-0 sell tickets:82
Thread-1Sell tickets : 81
sell():Thread-0 sell tickets:80
Thread-1Sell tickets : 79
sell():Thread-0 sell tickets:78
Thread-1Sell tickets : 77
sell():Thread-0 sell tickets:76
Thread-1Sell tickets : 75
sell():Thread-0 sell tickets:74
Thread-1Sell tickets : 73
sell():Thread-0 sell tickets:72
Thread-1Sell tickets : 71
sell():Thread-0 sell tickets:70
Thread-1Sell tickets : 69
sell():Thread-0 sell tickets:68
Thread-1Sell tickets : 67
sell():Thread-0 sell tickets:66
Thread-1Sell tickets : 65
sell():Thread-0 sell tickets:64
Thread-1Sell tickets : 63
sell():Thread-0 sell tickets:62
Thread-1Sell tickets : 61
sell():Thread-0 sell tickets:60
Thread-1Sell tickets : 59
sell():Thread-0 sell tickets:58
Thread-1Sell tickets : 57
sell():Thread-0 sell tickets:56
Thread-1Sell tickets : 55
sell():Thread-0 sell tickets:54
sell():Thread-0 sell tickets:53
Thread-1Sell tickets : 52
sell():Thread-0 sell tickets:51
Thread-1Sell tickets : 50
sell():Thread-0 sell tickets:49
Thread-1Sell tickets : 48
sell():Thread-0 sell tickets:47
Thread-1Sell tickets : 46
sell():Thread-0 sell tickets:45
Thread-1Sell tickets : 44
Thread-1Sell tickets : 43
sell():Thread-0 sell tickets:42
sell():Thread-0 sell tickets:41
Thread-1Sell tickets : 40
sell():Thread-0 sell tickets:39
Thread-1Sell tickets : 38
sell():Thread-0 sell tickets:37
Thread-1Sell tickets : 36
sell():Thread-0 sell tickets:35
Thread-1Sell tickets : 34
sell():Thread-0 sell tickets:33
Thread-1Sell tickets : 32
Thread-1Sell tickets : 31
sell():Thread-0 sell tickets:30
sell():Thread-0 sell tickets:29
Thread-1Sell tickets : 28
sell():Thread-0 sell tickets:27
Thread-1Sell tickets : 26
sell():Thread-0 sell tickets:25
Thread-1Sell tickets : 24
sell():Thread-0 sell tickets:23
Thread-1Sell tickets : 22
sell():Thread-0 sell tickets:21
Thread-1Sell tickets : 20
Thread-1Sell tickets : 19
sell():Thread-0 sell tickets:18
sell():Thread-0 sell tickets:17
Thread-1Sell tickets : 16
sell():Thread-0 sell tickets:15
Thread-1Sell tickets : 14
sell():Thread-0 sell tickets:13
Thread-1Sell tickets : 12
sell():Thread-0 sell tickets:11
Thread-1Sell tickets : 10
sell():Thread-0 sell tickets:9
Thread-1Sell tickets : 8
Thread-1Sell tickets : 7
sell():Thread-0 sell tickets:6
sell():Thread-0 sell tickets:5
Thread-1Sell tickets : 4
sell():Thread-0 sell tickets:3
Thread-1Sell tickets : 2
sell():Thread-0 sell tickets:1
Thread-1Sell tickets : 0

由于两个线程监视的对象不一样，出现了售出 0 号票的错误，
那么我们看看监视同一对象的效果：

//TicketsSystem.java
class TicketsSystem
{
	public static void main(String[] args)
	{
		SellThread st=new SellThread();
		new Thread(st).start();
		try
		{
			Thread.sleep(1);//这里等待1ms是为了让第一个线程启动起来，
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		st.b = true ;//第一个线程已经启动之后才设置st.b = true
		new Thread(st).start();

	}
}
class SellThread implements Runnable
{
	int tickets=100;
	Object obj = new Object();
	boolean b = false ;
	public void run()
	{
		if ( b == false )
		{
			while ( true )
			{
				sell();
			}

		}
		else
		{
			while ( true )
			{
				synchronized( this )//这里就是同步块
				{
					if ( tickets > 0 )
					{
						try
						{
							Thread.sleep( 10 );
						}
						catch( Exception e )
						{
							e.printStackTrace();
						}

						System.out.println( Thread.currentThread().getName() +
										"Sell tickets : " + tickets );
						tickets --;
					}
				}
			}
		}

	}
	public synchronized void sell()
	{

		if(tickets>0)
		{
			try
			{
				Thread.sleep(10);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			System.out.println("sell():"+Thread.currentThread().getName()+
					" sell tickets:"+tickets);
			tickets--;
		}
	}
}
E:\zieckey\Lesson7>javac TicketsSystem.java

E:\zieckey\Lesson7>java TicketsSystem
sell():Thread-0 sell tickets:100
Thread-1Sell tickets : 99
sell():Thread-0 sell tickets:98
Thread-1Sell tickets : 97
sell():Thread-0 sell tickets:96
Thread-1Sell tickets : 95
sell():Thread-0 sell tickets:94
Thread-1Sell tickets : 93
sell():Thread-0 sell tickets:92
Thread-1Sell tickets : 91
sell():Thread-0 sell tickets:90
Thread-1Sell tickets : 89
sell():Thread-0 sell tickets:88
Thread-1Sell tickets : 87
sell():Thread-0 sell tickets:86
Thread-1Sell tickets : 85
sell():Thread-0 sell tickets:84
Thread-1Sell tickets : 83
sell():Thread-0 sell tickets:82
Thread-1Sell tickets : 81
sell():Thread-0 sell tickets:80
Thread-1Sell tickets : 79
sell():Thread-0 sell tickets:78
Thread-1Sell tickets : 77
sell():Thread-0 sell tickets:76
Thread-1Sell tickets : 75
sell():Thread-0 sell tickets:74
Thread-1Sell tickets : 73
sell():Thread-0 sell tickets:72
Thread-1Sell tickets : 71
sell():Thread-0 sell tickets:70
Thread-1Sell tickets : 69
sell():Thread-0 sell tickets:68
Thread-1Sell tickets : 67
sell():Thread-0 sell tickets:66
Thread-1Sell tickets : 65
sell():Thread-0 sell tickets:64
Thread-1Sell tickets : 63
sell():Thread-0 sell tickets:62
Thread-1Sell tickets : 61
sell():Thread-0 sell tickets:60
Thread-1Sell tickets : 59
sell():Thread-0 sell tickets:58
Thread-1Sell tickets : 57
sell():Thread-0 sell tickets:56
Thread-1Sell tickets : 55
sell():Thread-0 sell tickets:54
sell():Thread-0 sell tickets:53
Thread-1Sell tickets : 52
sell():Thread-0 sell tickets:51
Thread-1Sell tickets : 50
sell():Thread-0 sell tickets:49
Thread-1Sell tickets : 48
sell():Thread-0 sell tickets:47
Thread-1Sell tickets : 46
sell():Thread-0 sell tickets:45
Thread-1Sell tickets : 44
Thread-1Sell tickets : 43
sell():Thread-0 sell tickets:42
sell():Thread-0 sell tickets:41
Thread-1Sell tickets : 40
sell():Thread-0 sell tickets:39
Thread-1Sell tickets : 38
sell():Thread-0 sell tickets:37
Thread-1Sell tickets : 36
sell():Thread-0 sell tickets:35
Thread-1Sell tickets : 34
sell():Thread-0 sell tickets:33
Thread-1Sell tickets : 32
Thread-1Sell tickets : 31
sell():Thread-0 sell tickets:30
sell():Thread-0 sell tickets:29
Thread-1Sell tickets : 28
sell():Thread-0 sell tickets:27
Thread-1Sell tickets : 26
sell():Thread-0 sell tickets:25
Thread-1Sell tickets : 24
sell():Thread-0 sell tickets:23
Thread-1Sell tickets : 22
sell():Thread-0 sell tickets:21
Thread-1Sell tickets : 20
Thread-1Sell tickets : 19
sell():Thread-0 sell tickets:18
sell():Thread-0 sell tickets:17
Thread-1Sell tickets : 16
sell():Thread-0 sell tickets:15
Thread-1Sell tickets : 14
sell():Thread-0 sell tickets:13
Thread-1Sell tickets : 12
sell():Thread-0 sell tickets:11
Thread-1Sell tickets : 10
sell():Thread-0 sell tickets:9
Thread-1Sell tickets : 8
Thread-1Sell tickets : 7
sell():Thread-0 sell tickets:6
sell():Thread-0 sell tickets:5
Thread-1Sell tickets : 4
sell():Thread-0 sell tickets:3
Thread-1Sell tickets : 2
sell():Thread-0 sell tickets:1
这样就好了。

这足以说明通过同步方法实现的同步，它监视的是this对象，
每一个对象都有一个监视器，或者叫做锁。
同步方法利用的是this所代表的对象的锁。
每个class也有一个锁，是这个class所对应的Class对象的锁。
那么就可以利用这个Class对象来同步静态变量.

死锁:
线程1锁住了对象A的监视器，等待对象B的监视器，线程2锁住了对象B的监视器，等待对象A的监视器，就造成了死锁。
我们看看下面的例子:

//TicketsSystem.java
class TicketsSystem
{
	public static void main(String[] args)
	{
		SellThread st=new SellThread();
		new Thread(st).start();
		try
		{
			Thread.sleep(1);//这里等待1ms是为了让第一个线程启动起来，
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		st.b = true ;//第一个线程已经启动之后才设置st.b = true
		new Thread(st).start();

	}
}
class SellThread implements Runnable
{
	int tickets=100;
	Object obj = new Object();
	boolean b = false ;
	public void run()
	{
		if ( b == false )
		{
			while ( true )
			{
				sell();
			}

		}
		else
		{
			while ( true )
			{
				synchronized(obj)
				{
					try
					{
						Thread.sleep(10);
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
					synchronized(this)
					{
						if(tickets>0)
						{

							System.out.println("obj:"+Thread.currentThread().getName()+
									" sell tickets:"+tickets);
							tickets--;
						}
					}
				}
			}
		}

	}
	public synchronized void sell()
	{

		synchronized(obj)
		{
			if(tickets>0)
			{
				try
				{
					Thread.sleep(10);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				System.out.println("sell():"+Thread.currentThread().getName()+
						" sell tickets:"+tickets);
				tickets--;
			}
		}
	}
}
E:\zieckey\Lesson7>javac TicketsSystem.java

E:\zieckey\Lesson7>java TicketsSystem
sell():Thread-0 sell tickets:100

E:\zieckey\Lesson7>


wait、notify、notifyAll
每一个对象除了有一个锁之外，还有一个等待队列（wait set），当一个对象刚创建的时候，它的对待队列是空的。
我们应该在当前线程锁住对象的锁后，去调用该对象的wait方法。
当调用对象的notify方法时，将从该对象的等待队列中删除一个任意选择的线程，这个线程将再次成为可运行的线程。
当调用对象的notifyAll方法时，将从该对象的等待队列中删除所有等待的线程，这些线程将成为可运行的线程。
wait和notify主要用于producer-consumer这种关系中。

看看下面的例子:

//TestWaitNotify.java
class TestWaitNotify
{
	public static void main(String[] args)
	{
		Queue q=new Queue();
		Producer p=new Producer(q);
		Consumer c=new Consumer(q);
		p.start();
		c.start();
	}
}

class Producer extends Thread
{
	Queue q;
	Producer(Queue q)
	{
		this.q=q;
	}
	public void run()
	{
		for(int i=0;i<10;i++)
		{
			q.put(i);
			System.out.println("Producer put "+i);
		}
	}
}
class Consumer extends Thread
{
	Queue q;
	Consumer(Queue q)
	{
		this.q=q;
	}
	public void run()
	{
		while(true)
		{
			System.out.println("Consumer get "+q.get());
		}
	}
}
class Queue
{
	int value;
	boolean bFull=false;
	public synchronized void put(int i)//对this对象进行加锁同步
	{
		if(!bFull)
		{
			value=i;
			bFull=true;
			notify();
		}
		try
		{
			wait();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}
	public synchronized int get()//对this对象进行加锁同步
	{
		if(!bFull)
		{
			try
			{
				wait();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		bFull=false;
		notify();
		return value;
	}
}
E:\zieckey\Lesson7>javac TestWaitNotify.java

E:\zieckey\Lesson7>java TestWaitNotify
Producer put 0
Consumer get 0
Producer put 1
Consumer get 1
Producer put 2
Consumer get 2
Producer put 3
Consumer get 3
Producer put 4
Consumer get 4
Producer put 5
Consumer get 5
Producer put 6
Consumer get 6
Producer put 7
Consumer get 7
Consumer get 8
Producer put 8
Consumer get 9
Producer put 9


线程的终止
不推荐用stop方法去终止一个线程,在stop方法调用的时候会将所有的锁解开,
这对于某些临界资源来说是致命的,因为本来这个临界资源应该被锁住,
但是一旦stop被执行,就解开了，其他线程就可以访问了。
线程的终止有两种可行的方法：
1.设置一个flag变量。
2.结合interrupt()方法。


1.设置一个flag变量。
//TestThreadStop.java
class TestThreadStop
{
	public static void main(String[] args)
	{
		Thread1 t1=new Thread1();
		t1.start();
		int index=0;
		while(true)
		{
			if(index++==50)
			{
				t1.stopThread();
				break;
			}
			System.out.println(Thread.currentThread().getName());
		}
		System.out.println("main() exit");
	}
}

class Thread1 extends Thread
{
	private boolean bStop=false;
	public void run()
	{
		while(!bStop)
		{
			System.out.println(getName());
		}
	}
	public void stopThread()
	{
		bStop=true;
	}
}
E:\zieckey\Lesson7>javac TestThreadStop.java

E:\zieckey\Lesson7>java TestThreadStop
main
main
main
main
main
main
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
main
main
main
main
main
main
main
main
main
main
main
main
main
main
main
main
main
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
main
main
main
main
main
main
main
main
main
main
main
main
main
main
main
main
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
main
main
main
main
main
main
main
main
main
main
main
main() exit

E:\zieckey\Lesson7>

但是如果我们有些wait方法的话，那么就不容易退出线程了。
//TestThreadStop.java
class TestThreadStop
{
	public static void main(String[] args)
	{
		Thread1 t1=new Thread1();
		t1.start();
		int index=0;
		while(true)
		{
			if(index++==50)
			{
				t1.stopThread();
				break;
			}
			System.out.println(Thread.currentThread().getName());
		}
		System.out.println("main() exit");
	}
}

class Thread1 extends Thread
{
	private boolean bStop=false;
	public synchronized void run()
	{
		while(!bStop)
		{
			try
			{
				wait();
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
			System.out.println(getName());
		}
	}
	public void stopThread()
	{
		bStop=true;
	}
}
E:\zieckey\Lesson7>javac TestThreadStop.java

E:\zieckey\Lesson7>java TestThreadStop
main
main
main
main
main
main
main
main
main
main
main
main
main
main
main
main
main
main
main
main
main
main
main
main
main
main
main
main
main
main
main
main
main
main
main
main
main
main
main
main
main
main
main
main
main
main
main
main
main
main
main() exit
从这里的运行结果是看不出来的，
但是在实际运行中，程序停在了那里，没有退出！
这个时候我们就要用得interrupt()方法。
class TestThread
{
	public static void main(String[] args)
	{
		Thread1 t1=new Thread1();
		t1.start();
		int index=0;
		while(true)
		{
			if(index++==50)
			{
				t1.stopThread();
				t1.interrupt();
				break;
			}
			System.out.println(Thread.currentThread().getName());
		}
		System.out.println("main() exit");
	}
}

class Thread1 extends Thread
{
	private boolean bStop=false;
	public synchronized void run()
	{
		while(!bStop)
		{
			try
			{
				System.out.println("before Wait");
				wait();
				System.out.println("after Wait");
			}
			catch(InterruptedException e)
			{
				if(bStop)
				{
					System.out.println("before thread return");
					return;
				}

			}
			System.out.println(getName());
		}
	}
	public void stopThread()
	{
		bStop=true;
	}
}
这个程序并没有像孙鑫老师讲课的说的那样退出，似乎不对？
后面再研究。。。。。


Lesson8
Java中的集合类


集合框架中的接口
Collection：集合层次中的根接口，JDK没有提供这个接口直接的实现类。
Set：不能包含重复的元素。SortedSet是一个按照升序排列元素的Set。
List：是一个有序的集合，可以包含重复的元素。提供了按索引访问的方式。
Map：包含了key-value对。Map不能包含重复的key。SortedMap是一个按照升序排列key的Map。



ArrayList
ArrayList：我们可以将其看作是能够自动增长容量的数组。
利用ArrayList的toArray()返回一个数组。
Arrays.asList()返回一个列表。
迭代器(Iterator) 给我们提供了一种通用的方式来访问集合中的元素。


//ArrayListTest.java
import java.util.*;
class ArrayListTest
{
	public static void main(String[] args)
	{
		ArrayList al=new ArrayList();
		al.add("winsun");
		al.add("weixin");
		al.add("mybole");

		for(int i=0;i<al.size();i++)
		{
			System.out.println(al.get(i));
		}

	}
}
运行结果：
winsun
weixin
mybole



//ArrayListTest.java
import java.util.*;
class ArrayListTest
{

	public static void main(String[] args)
	{
		ArrayList al=new ArrayList();

		al.add( new Point(2,2) );
		al.add( new Point(3,3) );
		al.add( new Point(4,4) );

		System.out.println( al );
		Object[] obj = al.toArray();//将这个ArrayList转换为数组
		for ( int i=0; i<obj.length; i++ )
		{
			System.out.println( obj[i] );
		}
	}
}
class Point
{
	int x,y;
	Point(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
	public String toString()
	{
		return "x="+x+" "+"y="+y;
	}
}
运行结果：
[x=2 y=2, x=3 y=3, x=4 y=4]
x=2 y=2
x=3 y=3
x=4 y=4
但是出现警告信息：
Severity and Description	Path	Resource	Location	Creation Time	Id
Type safety: The method add(Object) belongs to the raw type ArrayList. References to generic type ArrayList<E> should be parameterized	Lesson8	ArrayListTest.java	line 11	1167034673468	236
Type safety: The method add(Object) belongs to the raw type ArrayList. References to generic type ArrayList<E> should be parameterized	Lesson8	ArrayListTest.java	line 12	1167034673468	237
Type safety: The method add(Object) belongs to the raw type ArrayList. References to generic type ArrayList<E> should be parameterized	Lesson8	ArrayListTest.java	line 13	1167034673468	238

Tiger的泛型功能使得编译器对类型的安全性进行检查，特别是Java集合，如下面的例子：

public void nonGenericsMethod()
{
	ArrayList al = new ArrayList(); // no typing information on the List
	al.add("zieckey"); // causes error on list addition
}
编译器会给出下面的警告信息：
Type safety: The method add(Object) belongs to the raw type List. References to generic  type List<E> should be parameterized

这个可以使用@SuppressWarnings来阻止指定类型的警告信息，如：

@SuppressWarnings(value = { "unchecked" })
public void nonGenericsMethod()
{
	ArrayList al = new ArrayList(); // no typing information on the List
	al.add("zieckey"); // causes error on list addition
}

那么上面的代码就可以通过这方法阻止这些烦人的警告信息

//ArrayListTest.java

import java.util.*;
class ArrayListTest
{
	@SuppressWarnings(value = { "unchecked" })  //或者 @SuppressWarnings("unchecked")
	public static void main(String[] args)
	{

		ArrayList al = new ArrayList();
		al.add( new Point(2,2) );
		al.add( new Point(3,3) );
		al.add( new Point(4,4) );

		System.out.println( al );
		Object[] obj = al.toArray();//将这个ArrayList转换为数组
		for ( int i=0; i<obj.length; i++ )
		{
			System.out.println( obj[i] );
		}
	}
}
class Point
{
	int x,y;
	Point(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
	public String toString()
	{
		return "x="+x+" "+"y="+y;
	}
}
这样就可以编译不出现错误。

如果不加 @SuppressWarnings(value = { "unchecked" })  这行代码的话，
在命令行下编译是这个现象：

E:\JavaLesson\Lesson8>javac ArrayListTest.java
注意：ArrayListTest.java 使用了未经检查或不安全的操作。
注意：要了解详细信息，请使用 -Xlint:unchecked 重新编译。

那么可以通过加上 -Xlint:unchecked 重新编译。

但是这样还是会出现警告，
E:\JavaLesson\Lesson8>javac ArrayListTest.java -Xlint:unchecked
ArrayListTest.java:11: 警告：[unchecked] 对作为普通类型 java.util.ArrayList 的成
员的 add(E) 的调用未经检查
                al.add( new Point(2,2) );
                      ^
ArrayListTest.java:12: 警告：[unchecked] 对作为普通类型 java.util.ArrayList 的成
员的 add(E) 的调用未经检查
                al.add( new Point(3,3) );
                      ^
ArrayListTest.java:13: 警告：[unchecked] 对作为普通类型 java.util.ArrayList 的成
员的 add(E) 的调用未经检查
                al.add( new Point(4,4) );
                      ^
3 警告

所以还是加上那句话为好。


通过Arrays.asList()返回一个列表：
//ArrayListTest.java

import java.util.*;
class ArrayListTest
{
	@SuppressWarnings(value = { "unchecked" })  //或者 @SuppressWarnings("unchecked")

	public static void main(String[] args)
	{

		ArrayList al = new ArrayList();
		al.add( new Point(2,2) );
		al.add( new Point(3,3) );
		al.add( new Point(4,4) );

		System.out.println( al );
		Object[] obj = al.toArray();//将这个ArrayList转换为数组
		for ( int i=0; i<obj.length; i++ )
		{
			System.out.println( obj[i] );
		}

		List l = Arrays.asList( obj ); //将obj数组转换为一个List对象
		System.out.println( l );
	}
}
class Point
{
	int x,y;
	Point(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
	public String toString()
	{
		return "x="+x+" "+"y="+y;
	}
}
运行：
[x=2 y=2, x=3 y=3, x=4 y=4]
x=2 y=2
x=3 y=3
x=4 y=4
[x=2 y=2, x=3 y=3, x=4 y=4]




//ArrayListTest.java

import java.util.*;
class ArrayListTest
{
	@SuppressWarnings(value = { "unchecked" })  //或者 @SuppressWarnings("unchecked")

	public static void main(String[] args)
	{

		ArrayList al = new ArrayList();
		al.add( new Point(2,2) );
		al.add( new Point(3,3) );
		al.add( new Point(4,4) );

		System.out.println( al );
		Object[] obj = al.toArray();//将这个ArrayList转换为数组
		for ( int i=0; i<obj.length; i++ )
		{
			System.out.println( obj[i] );
		}

		List l = Arrays.asList( obj ); //将obj数组转换为一个List对象

		l.add( new Point(5,5) );//这里通过Arrays.asList()方法返回的一个固定尺寸的List
								//再增加就会出现异常

		System.out.println( l );


	}
}
class Point
{
	int x,y;
	Point(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
	public String toString()
	{
		return "x="+x+" "+"y="+y;
	}
}
运行：
[x=2 y=2, x=3 y=3, x=4 y=4]
x=2 y=2
x=3 y=3
x=4 y=4
Exception in thread "main" java.lang.UnsupportedOperationException
	at java.util.AbstractList.add(Unknown Source)
	at java.util.AbstractList.add(Unknown Source)
	at ArrayListTest.main(ArrayListTest.java:25)
所以不能给它增加成员了。

迭代器(Iterator) 给我们提供了一种通用的方式来访问集合中的元素。(List.Iterator())
//ArrayListTest.java

import java.util.*;
class ArrayListTest
{
	@SuppressWarnings(value = { "unchecked" })  //或者 @SuppressWarnings("unchecked")

	public static void main(String[] args)
	{

		ArrayList al = new ArrayList();
		al.add( new Point(2,2) );
		al.add( new Point(3,3) );
		al.add( new Point(4,4) );

		System.out.println( al );
		Object[] obj = al.toArray();//将这个ArrayList转换为数组
		for ( int i=0; i<obj.length; i++ )
		{
			System.out.println( obj[i] );
		}

		List l = Arrays.asList( obj ); //将obj数组转换为一个List对象
		System.out.println( l );

		System.out.println("Using Iterator...");

		Iterator it=l.iterator(); //返回一个迭代器
		while(it.hasNext())
		{
			System.out.println(it.next());
		}

	}
}
class Point
{
	int x,y;
	Point(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
	public String toString()
	{
		return "x="+x+" "+"y="+y;
	}
}
编译运行：
[x=2 y=2, x=3 y=3, x=4 y=4]
x=2 y=2
x=3 y=3
x=4 y=4
[x=2 y=2, x=3 y=3, x=4 y=4]
Using Iterator...
x=2 y=2
x=3 y=3
x=4 y=4

通过迭代器删除一个元素：
//ArrayListTest.java

import java.util.*;
class ArrayListTest
{
	@SuppressWarnings(value = { "unchecked" })  //或者 @SuppressWarnings("unchecked")

	public static void main(String[] args)
	{

		ArrayList al = new ArrayList();
		al.add( new Point(2,2) );
		al.add( new Point(3,3) );
		al.add( new Point(4,4) );

		System.out.println( al );
		Object[] obj = al.toArray();//将这个ArrayList转换为数组
		for ( int i=0; i<obj.length; i++ )
		{
			System.out.println( obj[i] );
		}

		List l = Arrays.asList( obj ); //将obj数组转换为一个List对象
		System.out.println( l );

		System.out.println("Using Iterator...");

		Iterator it=l.iterator(); //返回一个迭代器
		it.remove();//直接调用remove()会出现异常
		while(it.hasNext())
		{
			System.out.println(it.next());
		}

	}
}
class Point
{
	int x,y;
	Point(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
	public String toString()
	{
		return "x="+x+" "+"y="+y;
	}
}
运行：
[x=2 y=2, x=3 y=3, x=4 y=4]
x=2 y=2
x=3 y=3
x=4 y=4
[x=2 y=2, x=3 y=3, x=4 y=4]
Using Iterator...
Exception in thread "main" java.lang.IllegalStateException
	at java.util.AbstractList$Itr.remove(Unknown Source)
	at ArrayListTest.main(ArrayListTest.java:29)

void remove()Removes from the underlying collection the last element returned by the iterator (optional operation). This method can be called only once per call to next. The behavior of an iterator is unspecified if the underlying collection is modified while the iteration is in progress in any way other than by calling this method.

所以我们必须先让Iterator移动到下一个元素，然后执行删除操作，
这样会删除现在Iterator的上一个元素


//ArrayListTest.java
import java.util.*;
class ArrayListTest
{
	@SuppressWarnings(value = { "unchecked" })  //或者 @SuppressWarnings("unchecked")

	public static void main(String[] args)
	{

		ArrayList al = new ArrayList();
		al.add( new Point(2,2) );
		al.add( new Point(3,3) );
		al.add( new Point(4,4) );

		System.out.println( al );
		Object[] obj = al.toArray();//将这个ArrayList转换为数组
		for ( int i=0; i<obj.length; i++ )
		{
			System.out.println( obj[i] );
		}

		List l = Arrays.asList( obj ); //将obj数组转换为一个List对象
		System.out.println( l );

		System.out.println("Using Iterator...");

		Iterator it=l.iterator(); //返回一个迭代器
		it.next();
		it.remove();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}

	}
}
class Point
{
	int x,y;
	Point(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
	public String toString()
	{
		return "x="+x+" "+"y="+y;
	}
}

[x=2 y=2, x=3 y=3, x=4 y=4]
x=2 y=2
x=3 y=3
x=4 y=4
[x=2 y=2, x=3 y=3, x=4 y=4]
Using Iterator...
x=3 y=3
x=4 y=4
java.lang.UnsupportedOperationException
	at java.util.AbstractList.remove(Unknown Source)
	at java.util.AbstractList$Itr.remove(Unknown Source)
	at ArrayListTest.main(ArrayListTest.java:32)
然而现在还是出现异常,why?
异常信息是 UnsupportedOperationException ,
看看帮助文档:
void remove()Removes from the underlying collection the last element returned by the iterator (optional operation). This method can be called only once per call to next. The behavior of an iterator is unspecified if the underlying collection is modified while the iteration is in progress in any way other than by calling this method.
throws:
UnsupportedOperationException - if the remove operation is not supported by this Iterator.
IllegalStateException - if the next method has not yet been called, or the remove method has already been called after the last call to the next method.

那看看我们自行捕捉这个异常行不行呢？
//ArrayListTest.java

import java.util.*;
class ArrayListTest
{
	@SuppressWarnings(value = { "unchecked" })  //或者 @SuppressWarnings("unchecked")

	public static void main(String[] args)
	{

		ArrayList al = new ArrayList();
		al.add( new Point(2,2) );
		al.add( new Point(3,3) );
		al.add( new Point(4,4) );

		System.out.println( al );
		Object[] obj = al.toArray();//将这个ArrayList转换为数组
		for ( int i=0; i<obj.length; i++ )
		{
			System.out.println( obj[i] );
		}

		List l = Arrays.asList( obj ); //将obj数组转换为一个List对象
		System.out.println( l );

		System.out.println("Using Iterator...");

		Iterator it=l.iterator(); //返回一个迭代器
		it.next();
		try
		{
			it.remove();
		}
		catch ( Exception e )
		{
			e.printStackTrace();
		}
		while(it.hasNext())
		{
			System.out.println(it.next());
		}

	}
}
class Point
{
	int x,y;
	Point(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
	public String toString()
	{
		return "x="+x+" "+"y="+y;
	}
}


[x=2 y=2, x=3 y=3, x=4 y=4]
x=2 y=2
x=3 y=3
x=4 y=4
[x=2 y=2, x=3 y=3, x=4 y=4]
Using Iterator...
x=3 y=3
x=4 y=4
java.lang.UnsupportedOperationException
	at java.util.AbstractList.remove(Unknown Source)
	at java.util.AbstractList$Itr.remove(Unknown Source)
	at ArrayListTest.main(ArrayListTest.java:32)

还是一样的错误，看来是其他方面的原因。

哦,原来我们发现我们的迭代器是通过 Arrays.asList( obj )返回的 List 对象,
这种List是固定长度的，正如前面不能添加元素一样，现在执行删除操作也一样不行。
所以我们要进行这些操作的时候可以让迭代器从Arrays对象产生，如下：

//ArrayListTest.java

import java.util.*;
class ArrayListTest
{
	@SuppressWarnings(value = { "unchecked" })  //或者 @SuppressWarnings("unchecked")

	public static void main(String[] args)
	{

		ArrayList al = new ArrayList();
		al.add( new Point(2,2) );
		al.add( new Point(3,3) );
		al.add( new Point(4,4) );

		System.out.println( al );
		Object[] obj = al.toArray();//将这个ArrayList转换为数组
		for ( int i=0; i<obj.length; i++ )
		{
			System.out.println( obj[i] );
		}

		List l = Arrays.asList( obj ); //将obj数组转换为一个List对象
		System.out.println( l );

		System.out.println("Using Iterator...");

		Iterator it=al.iterator(); //返回一个迭代器
		it.next();
		it.remove();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}

	}
}
class Point
{
	int x,y;
	Point(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
	public String toString()
	{
		return "x="+x+" "+"y="+y;
	}
}

[x=2 y=2, x=3 y=3, x=4 y=4]
x=2 y=2
x=3 y=3
x=4 y=4
[x=2 y=2, x=3 y=3, x=4 y=4]
Using Iterator...
x=3 y=3
x=4 y=4

这样就好了。

迭代器(Iterator) 给我们提供了一种通用的方式来访问集合中的元素,
下面我们看看这种通用方法的好处：

//ArrayListTest.java

import java.util.*;
class ArrayListTest
{
	/**
	 * 这里提供了一个对集合类通用的访问方法，这对于程序而言是很方便的
	 */
	public static void printElement( Collection c )
	{
		Iterator it = c.iterator();
		while ( it.hasNext() )
		{
			System.out.println( it.next() );
		}
	}
	@SuppressWarnings(value = { "unchecked" })  //或者 @SuppressWarnings("unchecked")
	public static void main(String[] args)
	{

		ArrayList al = new ArrayList();
		al.add( new Point(2,2) );
		al.add( new Point(3,3) );
		al.add( new Point(4,4) );

		System.out.println( al );
		Object[] obj = al.toArray();//将这个ArrayList转换为数组
		for ( int i=0; i<obj.length; i++ )
		{
			System.out.println( obj[i] );
		}
		List l = Arrays.asList( obj ); //将obj数组转换为一个List对象
		System.out.println( l );
		System.out.println("A Function using iterator...");
		printElement( al );

	}
}
class Point
{
	int x,y;
	Point(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
	public String toString()
	{
		return "x="+x+" "+"y="+y;
	}
}

[x=2 y=2, x=3 y=3, x=4 y=4]
x=2 y=2
x=3 y=3
x=4 y=4
[x=2 y=2, x=3 y=3, x=4 y=4]
A Function using iterator...
x=2 y=2
x=3 y=3
x=4 y=4


Collections类
排序：Collections.sort()
（1）自然排寻(natural ordering )；
（2）实现比较器(Comparator)接口。
取最大和最小的元素：Collections.max()、Collections.min()。
在已排序的List中搜索指定的元素：Collectons.binarySearch()。


sort
public static <T extends Comparable<? super T>> void sort(List<T> list)根据元素的自然顺序 对指定列表按升序进行排序。列表中的所有元素都必须实现 Comparable 接口。此外，列表中的所有元素都必须是可相互比较的（也就是说，对于列表中的任何 e1 和 e2 元素，e1.compareTo(e2) 不得抛出 ClassCastException）。

//ArrayListTest.java

import java.util.*;
class ArrayListTest
{

	public static void printElement( Collection c )
	{
		Iterator it = c.iterator();
		while ( it.hasNext() )
		{
			System.out.println( it.next() );
		}
	}
	@SuppressWarnings(value = { "unchecked" })  //或者 @SuppressWarnings("unchecked")
	public static void main(String[] args)
	{

		ArrayList al = new ArrayList();
		al.add( new Student(2,"zhangsan") );
		al.add( new Student(3,"lisi") );
		al.add( new Student(1,"wangwu") );

		System.out.println( "Before Sorting" );
		printElement( al );
		Collections.sort( al );//排序
		System.out.println( "After Sorting" );
		printElement( al );

	}
}

class Student implements Comparable
{
	int num;
	String name;

	Student(int num,String name)
	{
		this.num=num;
		this.name=name;
	}

	public int compareTo(Object o)//这里是为了进行sort排序而必须实现的接口函数
	{
		Student s=(Student)o;
		return num > s.num ? 1 : (num==s.num ? 0 : -1);
	}
	public String toString()//这个是为了打印而必须实现的接口函数
	{
		return num+":"+name;
	}
}

Before Sorting
2:zhangsan
3:lisi
1:wangwu
After Sorting
1:wangwu
2:zhangsan
3:lisi





在排序的时候还可以传递一个比较器，这样就不需要实现Comparable接口
static <T> void sort(List<T> list, Comparator<? super T> c)
          根据指定比较器产生的顺序对指定列表进行排序。
//ArrayListTest.java
import java.util.*;
class ArrayListTest
{
	public static void printElement( Collection c )
	{
		Iterator it = c.iterator();
		while ( it.hasNext() )
		{
			System.out.println( it.next() );
		}
	}
	@SuppressWarnings(value = { "unchecked" })  //或者 @SuppressWarnings("unchecked")
	public static void main(String[] args)
	{
		ArrayList al = new ArrayList();
		al.add( new Student(2,"zhangsan") );
		al.add( new Student(3,"lisi") );
		al.add( new Student(3,"apple") );
		al.add( new Student(1,"wangwu") );

		System.out.println( "Before Sorting" );
		printElement( al );
		Collections.sort( al, new Student.StudentComparator() );//通过指定比较器进行排序
		System.out.println( "After Sorting" );
		printElement( al );
	}
}
class Student// implements Comparable
{
	int num;
	String name;

	Student(int num,String name)
	{
		this.num=num;
		this.name=name;
	}

	//构造一个内部类来实现sort方法按指定比较器产生的顺序对指定列表进行排序。
	static class StudentComparator implements Comparator
	{
		public int compare(Object o1,Object o2)
		{
			Student s1=(Student)o1;
			Student s2=(Student)o2;
			int result=s1.num > s2.num ? 1 : (s1.num==s2.num ? 0 : -1);
			return result;
		}
	}
	public String toString()//这个是为了打印而必须实现的接口函数
	{
		return num+":"+name;
	}
}

Before Sorting
2:zhangsan
3:lisi
3:apple
1:wangwu
After Sorting
1:wangwu
2:zhangsan
3:lisi
3:apple

这里我们想如果序号相等，就按照名字在进行排序，就像上面的apple应该排在lisi前面，
因为我们有了比较器，那么这样实现起来很方便，只需将compare方法重写如下：
		public int compare(Object o1,Object o2)
		{
			Student s1=(Student)o1;
			Student s2=(Student)o2;
			int result=s1.num > s2.num ? 1 : (s1.num==s2.num ? 0 : -1);
			if( result==0 )
			{
				result=s1.name.compareTo(s2.name);
			}
			return result;
		}

完整的程序如下：
//ArrayListTest.java
import java.util.*;
class ArrayListTest
{
	public static void printElement( Collection c )
	{
		Iterator it = c.iterator();
		while ( it.hasNext() )
		{
			System.out.println( it.next() );
		}
	}
	@SuppressWarnings(value = { "unchecked" })  //或者 @SuppressWarnings("unchecked")
	public static void main(String[] args)
	{
		ArrayList al = new ArrayList();
		al.add( new Student(2,"zhangsan") );
		al.add( new Student(3,"lisi") );
		al.add( new Student(3,"apple") );
		al.add( new Student(1,"wangwu") );

		System.out.println( "Before Sorting" );
		printElement( al );
		Collections.sort( al, new Student.StudentComparator() );//通过指定比较器进行排序
		System.out.println( "After Sorting" );
		printElement( al );
	}
}
class Student// implements Comparable
{
	int num;
	String name;

	Student(int num,String name)
	{
		this.num=num;
		this.name=name;
	}

	//构造一个内部类来实现sort方法按指定比较器产生的顺序对指定列表进行排序。
	static class StudentComparator implements Comparator
	{
		public int compare(Object o1,Object o2)
		{
			Student s1=(Student)o1;
			Student s2=(Student)o2;
			int result=s1.num > s2.num ? 1 : (s1.num==s2.num ? 0 : -1);
			if( result==0 )
			{
				result=s1.name.compareTo(s2.name);
			}
			return result;
		}
	}
	public String toString()//这个是为了打印而必须实现的接口函数
	{
		return num+":"+name;
	}
}
Before Sorting
2:zhangsan
3:lisi
3:apple
1:wangwu
After Sorting
1:wangwu
2:zhangsan
3:apple
3:lisi


如果要反序排列，那很好办，Collections类中有这样的一个方法 Collections.reverseOrder()) ，
完全可以实现。

//ArrayListTest.java
import java.util.*;
class ArrayListTest
{
	public static void printElement( Collection c )
	{
		Iterator it = c.iterator();
		while ( it.hasNext() )
		{
			System.out.println( it.next() );
		}
	}
	@SuppressWarnings(value = { "unchecked" })  //或者 @SuppressWarnings("unchecked")
	public static void main(String[] args)
	{
		ArrayList al = new ArrayList();
		al.add( new Student(2,"zhangsan") );
		al.add( new Student(3,"apple") );
		al.add( new Student(3,"lisi") );
		al.add( new Student(1,"wangwu") );

		System.out.println( "Before Sorting" );
		printElement( al );
		Collections.sort( al, Collections.reverseOrder() );//通过指定比较器进行排序
		System.out.println( "After Sorting" );
		printElement( al );
	}
}
class Student// implements Comparable
{
	int num;
	String name;

	Student(int num,String name)
	{
		this.num=num;
		this.name=name;
	}

	//构造一个内部类来实现sort方法按指定比较器产生的顺序对指定列表进行排序。
	static class StudentComparator implements Comparator
	{
		public int compare(Object o1,Object o2)
		{
			Student s1=(Student)o1;
			Student s2=(Student)o2;
			int result=s1.num > s2.num ? 1 : (s1.num==s2.num ? 0 : -1);
			if( result==0 )
			{
				result=s1.name.compareTo(s2.name);
			}
			return result;
		}
	}
	public String toString()//这个是为了打印而必须实现的接口函数
	{
		return num+":"+name;
	}
}

但是这样会出错：
Before Sorting
2:zhangsan
3:apple
3:lisi
1:wangwu
Exception in thread "main" java.lang.ClassCastException: Student
	at java.util.Collections$ReverseComparator.compare(Unknown Source)
	at java.util.Arrays.mergeSort(Unknown Source)
	at java.util.Arrays.sort(Unknown Source)
	at java.util.Collections.sort(Unknown Source)
	at ArrayListTest.main(ArrayListTest.java:24)
错误信息高诉我们，我们没有实现ReverseComparator.compare()方法，
哦，我们没有实现compare方法
这个好办我们实现Comparable接口就好了，
//ArrayListTest.java
import java.util.*;
class ArrayListTest
{
	public static void printElement( Collection c )
	{
		Iterator it = c.iterator();
		while ( it.hasNext() )
		{
			System.out.println( it.next() );
		}
	}
	@SuppressWarnings(value = { "unchecked" })  //或者 @SuppressWarnings("unchecked")
	public static void main(String[] args)
	{
		ArrayList al = new ArrayList();
		al.add( new Student(3,"apple") );
		al.add( new Student(2,"zhangsan") );
		al.add( new Student(3,"lisi") );
		al.add( new Student(1,"wangwu") );

		System.out.println( "Before Sorting" );
		printElement( al );
		Collections.sort( al, Collections.reverseOrder() );//通过指定比较器进行排序
		System.out.println( "After Sorting" );
		printElement( al );
	}
}
class Student implements Comparable
{
	int num;
	String name;

	Student(int num,String name)
	{
		this.num=num;
		this.name=name;
	}

	/*//构造一个内部类来实现sort方法按指定比较器产生的顺序对指定列表进行排序。
	static class StudentComparator implements Comparator
	{
		public int compare(Object o1,Object o2)
		{
			Student s1=(Student)o1;
			Student s2=(Student)o2;
			int result=s1.num > s2.num ? 1 : (s1.num==s2.num ? 0 : -1);
			if( result==0 )
			{
				result=s1.name.compareTo(s2.name);
			}
			return result;
		}
	}*/
	public int compareTo(Object o)//这里是为了进行sort排序而必须实现的接口函数
	{
		Student s=(Student)o;
		return num > s.num ? 1 : (num==s.num ? 0 : -1);
	}
	public String toString()//这个是为了打印而必须实现的接口函数
	{
		return num+":"+name;
	}
}

Before Sorting
3:lisi
2:zhangsan
3:apple
1:wangwu
After Sorting
3:apple
3:lisi
2:zhangsan
1:wangwu

这里出现了同样序号的排序有些问题的问题，我们想序号相同后，继续通过名字排序，
即是list比apple大，那么反序就应该list在apple前.
好多,看看帮助文档, reverseOrder(Comparator<T> cmp) 也可以通过指定的比较器进行排序,
这样就好办多了.

//ArrayListTest.java
import java.util.*;
class ArrayListTest
{
	public static void printElement( Collection c )
	{
		Iterator it = c.iterator();
		while ( it.hasNext() )
		{
			System.out.println( it.next() );
		}
	}
	@SuppressWarnings(value = { "unchecked" })  //或者 @SuppressWarnings("unchecked")
	public static void main(String[] args)
	{
		ArrayList al = new ArrayList();
		al.add( new Student(3,"apple") );
		al.add( new Student(2,"zhangsan") );
		al.add( new Student(3,"lisi") );
		al.add( new Student(1,"wangwu") );

		System.out.println( "Before Sorting" );
		printElement( al );
		Collections.sort( al, Collections.reverseOrder( new Student.StudentComparator() ) );//通过指定比较器进行排序
		System.out.println( "After Sorting" );
		printElement( al );
	}
}
class Student
{
	int num;
	String name;

	Student(int num,String name)
	{
		this.num=num;
		this.name=name;
	}

	//构造一个内部类来实现sort方法按指定比较器产生的顺序对指定列表进行排序。
	static class StudentComparator implements Comparator
	{
		public int compare(Object o1,Object o2)
		{
			Student s1=(Student)o1;
			Student s2=(Student)o2;
			int result=s1.num > s2.num ? 1 : (s1.num==s2.num ? 0 : -1);
			if( result==0 )
			{
				result=s1.name.compareTo(s2.name);
			}
			return result;
		}
	}
	public String toString()//这个是为了打印而必须实现的接口函数
	{
		return num+":"+name;
	}
}

Before Sorting
3:apple
2:zhangsan
3:lisi
1:wangwu
After Sorting
3:lisi
3:apple
2:zhangsan
1:wangwu

取最大和最小的元素：Collections.max()、Collections.min()。
在已排序的List中搜索指定的元素：Collectons.binarySearch()。

LinkedList
LinkedList是采用双向循环链表实现的。
利用LinkedList实现栈(stack)、队列(queue)、双向队列(double-ended queue )。


栈(Stack)也是一种特殊的线性表，是一种后进先出(LIFO)的结构。
栈是限定仅在表尾进行插入和删除运算的线性表，表尾称为栈顶(top)，表头称为栈底(bottom)。
栈的物理存储可以用顺序存储结构，也可以用链式存储结构。

利用LinkedList实现栈(stack):

//MyStack.java
import java.util.*;
public class MyStack {

	/**
	 * @param args
	 */
	private LinkedList ll=new LinkedList();
	@SuppressWarnings(value = { "unchecked" })
	public void push(Object o)//压入一个元素,这里是加入一个元素到表头
	{
		ll.addFirst( o );
	}
	public Object pop()//弹出一个元素
	{
		return ll.removeFirst();
	}
	public Object peek()
	{
		return ll.getFirst();
	}
	public boolean empty()
	{
		return ll.isEmpty();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyStack ms=new MyStack();
		ms.push("one");
		ms.push("two");
		ms.push("three");

		System.out.println(ms.pop());
		System.out.println(ms.peek());
		System.out.println(ms.pop());
		System.out.println(ms.empty());
	}

}

three
two
two
false


队列(Queue)是限定所有的插入只能在表的一端进行，而所有的删除都在表的另一端进行的线性表。
表中允许插入的一端称为队尾(Rear)，允许删除的一端称为队头(Front)。
队列的操作是按先进先出(FIFO)的原则进行的。
队列的物理存储可以用顺序存储结构，也可以用链式存储结构。

//MyQueue.java
import java.util.*;
public class MyQueue {

	/**
	 * @param args
	 */
	private LinkedList ll=new LinkedList();
	@SuppressWarnings(value = { "unchecked" })
	public void put(Object o)
	{
		ll.addLast(o);
	}
	public Object get()
	{
		return ll.removeFirst();
	}
	public boolean empty()
	{
		return ll.isEmpty();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyQueue mq=new MyQueue();
		mq.put("one");
		mq.put("two");
		mq.put("three");

		System.out.println(mq.get());
		System.out.println(mq.get());
		System.out.println(mq.get());
		System.out.println(mq.empty());
	}

}
one
two
three
true

ArrayList和LinkedList的比较
ArrayList底层采用数组完成，而LinkedList则是以一般的双向链表(double-linked list)完成，其内每个对象除了数据本身外，还有两个 引用，分别指向前一个元素和后一个元素。
如果我们经常在List的开始处增加元素，或者在List中进行插入和删除操作，我们应该使用LinkedList，否则的话，使用ArrayList将更加快速。


HashSet
实现Set接口的hash table(哈希表)，依靠HashMap来实现的。
我们应该为要存放到散列表的各个对象定义hashCode()和equals()。
散列表又称为哈希表。散列表算法的基本思想是：
  以结点的关键字为自变量，通过一定的函数关系（散列函数）计算出对应的函数值，以这个值作为该结点存储在散列表中的地址。
当散列表中的元素存放太满，就必须进行再散列，将产生一个新的散列表，所有元素存放到新的散列表中，原先的散列表将被删除。在Java语言中，通过负载因子(load factor)来决定何时对散列表进行再散列。例如：如果负载因子是0.75，当散列表中已经有75%的位置已经放满，那么将进行再散列。
负载因子越高(越接近1.0)，内存的使用效率越高，元素的寻找时间越长。负载因子越低(越接近0.0)，元素的寻找时间越短，内存浪费越多。
HashSet类的缺省负载因子是0.75。

//HashSetTest.java
import java.util.*;
public class HashSetTest {

	/**
	 * @param args
	 */
	@SuppressWarnings(value = { "unchecked" })
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet hs=new HashSet();
		hs.add("one");
		hs.add("two");
		hs.add("three");
		hs.add("one");//HashSet实现了Set接口，所以不能出现重复的元素，这里将会忽略
		Iterator it=hs.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
	}
}
打印输出:
one
two
three




//HashSetTest.java
import java.util.*;
public class HashSetTest {

	/**
	 * @param args
	 */
	@SuppressWarnings(value = { "unchecked" })
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet hs=new HashSet();
		hs.add(new Student(1,"zhangsan"));
		hs.add(new Student(2,"lisi"));
		hs.add(new Student(3,"wangwu"));
		hs.add(new Student(1,"zhangsan"));
		Iterator it=hs.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
	}
}
class Student
{
	int num;
	String name;
	Student(int num,String name)
	{
		this.num=num;
		this.name=name;
	}
	public String toString()
	{
		return num+":"+name;
	}
}

3:wangwu
2:lisi
1:zhangsan
1:zhangsan
这里出现了相同的元素被存放到HashSet中,为什么?
因为HashSet是根据Object类中hashCode()函数计算出哈希码来决定元素在哈希表中的位置,
但是hashCode()函数是根据对象的内部地址来计算的
为了避免这些情况的发生，我们必须将待添加到HashSet表中的对象重载 hashCode() 和 equals() 方法.
我们应该为要存放到散列表的各个对象定义hashCode()和equals()。
下面我们这样试一试:
//HashSetTest.java
import java.util.*;
public class HashSetTest {

	/**
	 * @param args
	 */
	@SuppressWarnings(value = { "unchecked" })
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet hs=new HashSet();
		hs.add(new Student(1,"zhangsan"));
		hs.add(new Student(2,"lisi"));
		hs.add(new Student(3,"wangwu"));
		hs.add(new Student(1,"zhangsan"));
		Iterator it=hs.iterator();
		while( it.hasNext() ) {
			System.out.println(it.next());
		}
	}
}
class Student
{
	int num;
	String name;
	Student(int num,String name)
	{
		this.num=num;
		this.name=name;
	}
	public int hashCode()
	{
		return num*name.hashCode();
	}
	public boolean equals(Object o)
	{
		Student s=(Student)o;
		return num==s.num && name.equals(s.name);
	}
	public String toString()
	{
		return num+":"+name;
	}
}

1:zhangsan
3:wangwu
2:lisi

这样就没有同样的输出了.

TreeSet
TreeSet是依靠TreeMap来实现的。
TreeSet是一个有序集合，TreeSet中元素将按照升序排列，缺省是按照自然顺序进行排列，意味着TreeSet中元素要实现Comparable接口。
我们可以在构造TreeSet对象时，传递实现了Comparator接口的比较器对象。


//TreeSetTest.java
import java.util.*;
public class TreeSetTest
{
	@SuppressWarnings(value = { "unchecked" })
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		TreeSet ts=new TreeSet();
		ts.add("winsun");
		ts.add("weixin");
		ts.add("mybole");

		Iterator it=ts.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
	}
}
E:\zieckey\Lesson8>javac TreeSetTest.java

E:\zieckey\Lesson8>java TreeSetTest
mybole
weixin
winsun

我们也可以增加实现了Comparable接口的类对象：
//TreeSetTest.java
import java.util.*;
public class TreeSetTest
{
	@SuppressWarnings(value = { "unchecked" })
	public static void main(String[] args)
	{
		TreeSet ts=new TreeSet();
		ts.add(new Student(2,"lisi"));
		ts.add(new Student(1,"wangwu"));
		ts.add(new Student(3,"zhangsan"));


		Iterator it=ts.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
	}
}
class Student implements Comparable
{
	int num;
	String name;

	Student(int num,String name)
	{
		this.num=num;
		this.name=name;
	}
	public int compareTo(Object o)//这里是为了进行sort排序而必须实现的接口函数
	{
		Student s=(Student)o;
		return num > s.num ? 1 : (num==s.num ? 0 : -1);
	}
	public String toString()//这个是为了打印而必须实现的接口函数
	{
		return num+":"+name;
	}
}
E:\zieckey\Lesson8>javac TreeSetTest.java

E:\zieckey\Lesson8>java TreeSetTest
1:wangwu
2:lisi
3:zhangsan

或者传递一个比较器的对象：
//TreeSetTest.java
import java.util.*;
public class TreeSetTest
{
	@SuppressWarnings(value = { "unchecked" })
	public static void main(String[] args)
	{
		TreeSet ts=new TreeSet( new Student.StudentComparator() );
		ts.add(new Student(2,"lisi"));
		ts.add(new Student(1,"wangwu"));
		ts.add(new Student(3,"zhangsan"));


		Iterator it=ts.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
	}
}
class Student //implements Comparable
{
	int num;
	String name;

	Student(int num,String name)
	{
		this.num=num;
		this.name=name;
	}
	//构造一个内部类来实现sort方法按指定比较器产生的顺序对指定列表进行排序。
	static class StudentComparator implements Comparator
	{
		public int compare(Object o1,Object o2)
		{
			Student s1=(Student)o1;
			Student s2=(Student)o2;
			int result=s1.num > s2.num ? 1 : (s1.num==s2.num ? 0 : -1);
			if( result==0 )
			{
				result=s1.name.compareTo(s2.name);
			}
			return result;
		}
	}
	/*public int compareTo(Object o)//这里是为了进行sort排序而必须实现的接口函数
	{
		Student s=(Student)o;
		return num > s.num ? 1 : (num==s.num ? 0 : -1);
	}*/
	public String toString()//这个是为了打印而必须实现的接口函数
	{
		return num+":"+name;
	}
}
E:\zieckey\Lesson8>javac TreeSetTest.java

E:\zieckey\Lesson8>java TreeSetTest
1:wangwu
2:lisi
3:zhangsan
HashSet和TreeSet的比较
HashSet是基于Hash算法实现的，其性能通常都优于TreeSet。我们通常都应该使用HashSet，在我们需要排序的功能时，我们才使用TreeSet。


HashMap
HashMap对key进行散列。
keySet()、values()、entrySet()。
import java.util.*;
class HashMapTest
{
	public static void printElements(Collection c)
	{
		Iterator it=c.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
	}
	@SuppressWarnings(value = { "unchecked" })
	public static void main(String[] args)
	{
		HashMap hm=new HashMap();
		hm.put("one","zhangsan");
		hm.put("two","lisi");
		hm.put("three","wangwu");

		System.out.println(hm.get("one"));
		System.out.println(hm.get("two"));
		System.out.println(hm.get("three"));


		Set keys=hm.keySet();
		System.out.println("Key:");
		printElements(keys);

		Collection values=hm.values();
		System.out.println("Value:");
		printElements(values);

		System.out.println("EntrySet:");
		Set entry=hm.entrySet();
		printElements(entry);

		System.out.println("EntrySet");
		Iterator it=entry.iterator();
		while(it.hasNext())
		{
			Map.Entry me=(Map.Entry)it.next();
			System.out.println(me.getKey()+":"+me.getValue());
		}
	}
}
E:\zieckey\Lesson8>javac HashMapTest.java

E:\zieckey\Lesson8>java HashMapTest
zhangsan
lisi
wangwu
Key:
one
two
three
Value:
zhangsan
lisi
wangwu
EntrySet:
one=zhangsan
two=lisi
three=wangwu
EntrySet
one:zhangsan
two:lisi
three:wangwu

Properties 类表示了一个持久的属性集。Properties 可保存在流中或从流中加载。属性列表中每个键及其对应值都是一个字符串。

import java.util.*;
class PropertyTest
{
	public static void main(String[] args)
	{
		Properties pps=System.getProperties();
		pps.list(System.out);
	}
}

-- listing properties --
java.runtime.name=Java(TM) 2 Runtime Environment, Stand...
sun.boot.library.path=C:\Program Files\Java\jre1.5.0_08\bin
java.vm.version=1.5.0_08-b03
java.vm.vendor=Sun Microsystems Inc.
java.vendor.url=http://java.sun.com/
path.separator=;
java.vm.name=Java HotSpot(TM) Client VM
file.encoding.pkg=sun.io
user.country=CN
sun.os.patch.level=Service Pack 2
java.vm.specification.name=Java Virtual Machine Specification
user.dir=E:\JavaLesson\Lesson8
java.runtime.version=1.5.0_08-b03
java.awt.graphicsenv=sun.awt.Win32GraphicsEnvironment
java.endorsed.dirs=C:\Program Files\Java\jre1.5.0_08\lib...
os.arch=x86
java.io.tmpdir=M:\DOCUME~1\apple\LOCALS~1\Temp\
line.separator=

java.vm.specification.vendor=Sun Microsystems Inc.
user.variant=
os.name=Windows XP
sun.jnu.encoding=GBK
java.library.path=C:\Program Files\Java\jre1.5.0_08\bin...
java.specification.name=Java Platform API Specification
java.class.version=49.0
sun.management.compiler=HotSpot Client Compiler
os.version=5.1
user.home=M:\Documents and Settings\apple
user.timezone=
java.awt.printerjob=sun.awt.windows.WPrinterJob
file.encoding=GBK
java.specification.version=1.5
user.name=apple
java.class.path=E:\JavaLesson\Lesson8
java.vm.specification.version=1.0
sun.arch.data.model=32
java.home=C:\Program Files\Java\jre1.5.0_08
java.specification.vendor=Sun Microsystems Inc.
user.language=zh
awt.toolkit=sun.awt.windows.WToolkit
java.vm.info=mixed mode, sharing
java.version=1.5.0_08
java.ext.dirs=C:\Program Files\Java\jre1.5.0_08\lib...
sun.boot.class.path=C:\Program Files\Java\jre1.5.0_08\lib...
java.vendor=Sun Microsystems Inc.
file.separator=\
java.vendor.url.bug=http://java.sun.com/cgi-bin/bugreport...
sun.cpu.endian=little
sun.io.unicode.encoding=UnicodeLittle
sun.desktop=windows
sun.cpu.isalist=pentium_pro+mmx pentium_pro pentium+m...



利用Properties类来加载文件内容类似如下的：
company=winsun
author=sunxin
copyright=2003-2004

该文件保存在winsun.ini中，那么程序中可以这样读取文件内容：

import java.util.*;
import java.io.*;
class PropertyTest
{
	public static void main(String[] args)
	{
		Properties pps=new Properties();
		try
		{
			pps.load(new FileInputStream("winsun.ini"));
			Enumeration enumer=pps.propertyNames();
			while(enumer.hasMoreElements())
			{
				String strKey=(String)enumer.nextElement();
				String strValue=pps.getProperty(strKey);

				System.out.println(strKey+"="+strValue);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
输出：
company=winsun
copyright=2003-2004
author=sunxin



Lesson9
Java I/O操作

File类
一个File类的对象，表示了磁盘上的文件或目录。
File类提供了与平台无关的方法来对磁盘上的文件或目录进行操作。


package file;
import java.io.*;
public class FileTest {
	public static void main(String[] args) {
		File f = new File( "1.txt" );
		try{
			f.createNewFile();
			f.mkdir();
		}
		catch( Exception e ){
			e.printStackTrace();
		}
	}
}
这样只会在当前目录下创建一个 1.txt 文件，而不会创建 1.txt 文件夹。
package file;
import java.io.*;
public class FileTest {
	public static void main(String[] args) {
		File f = new File( "1.txt" );
		try{
			f.mkdir();
		}
		catch( Exception e ){
			e.printStackTrace();
		}
	}
}
这样就会创建一个文件夹。

也可以在指定路径创建新文件，
package file;
import java.io.*;
public class FileTest {
	public static void main(String[] args) {
		File f = new File( "E:\\JavaLesson\\Lesson9\\1.txt" );
		try{
			f.createNewFile();
		}
		catch( Exception e ){
			e.printStackTrace();
		}
	}
}
这样写的代码如果移植到Linux下就会出现问题，因为路径格式不对。
下面是创建一个文件，而与平台无关。
package file;
import java.io.*;
public class FileTest {
	public static void main(String[] args) {
		//File.separator表示了目录分隔符，它不依赖于特定操作系统
		//File.separator直接用可以表示Window当前盘符的根目录
		File fDir=new File(File.separator);
		String strFile="JavaLesson"+File.separator+"Lesson9"+
			File.separator+"2.txt";
		File f=new File(fDir,strFile);//新建一个File对象
		try{
			f.createNewFile();
		}
		catch( Exception e ){
			e.printStackTrace();
		}
	}
}

删除文件或目录：
 boolean delete()
          删除此抽象路径名表示的文件或目录。
 void deleteOnExit()
          在虚拟机终止时，请求删除此抽象路径名表示的文件或目录。

在程序中创建临时文件，然后再程序退出时删除临时文件。
//FileTest.java
package file;
import java.io.*;
public class FileTest {
	public static void main(String[] args) {
		for(int i=0;i<5;i++)
		{
			try{
				File f=File.createTempFile("winsun",".tmp");
				f.deleteOnExit();
			}
			catch( Exception e ){
				e.printStackTrace();
			}

		}
		try{
			Thread.sleep(5000);
		}
		catch( Exception e ){
			e.printStackTrace();
		}
	}
}


 String[] list()
          返回由此抽象路径名所表示的目录中的文件和目录的名称所组成字符串数组。
//FileTest.java
package file;
import java.io.*;
public class FileTest {
	public static void main(String[] args) {
		File fDir=new File(File.separator);
		String strFile="JavaLesson"+File.separator+"Lesson9";
		File f=new File(fDir,strFile);
		String[] names=f.list();
		for(int i=0;i<names.length;i++)
		{
			System.out.println(names[i]);
		}
	}
}
输出：
.project
.classpath
src
bin
1.txt
2.txt

String[] list(FilenameFilter filter)
          返回由包含在目录中的文件和目录的名称所组成的字符串数组，这一目录是通过满足指定过滤器的抽象路径名来表示的。
//FileTest.java
package file;
import java.io.*;
public class FileTest {
	public static void main(String[] args) {
		File fDir=new File(File.separator);
		String strFile="JavaLesson"+File.separator+"Lesson9";
		File f=new File(fDir,strFile);
		String[] names=f.list(new FilenameFilter() //创建一个过滤器，它是个接口，
		{//通过匿名的内部类创建这个接口的实例对象
			public boolean accept(File dir,String name)
			{
				return name.indexOf(".txt")!=-1;
			}
		});
		for(int i=0;i<names.length;i++)
		{
			System.out.println(names[i]);
		}
	}
}

E:\JavaLesson\Lesson9\src\file>javac FileTest.java -d .

E:\JavaLesson\Lesson9\src\file>java file.FileTest
1.txt
2.txt


流式I/O
流(Stream)是字节的源或目的。
两种基本的流是：输入流(Input Stream)和输出流(Output Stream)。可从中读出一系列字节的对象称为输入流。而能向其中写入一系列字节的对象称为输出流。

流的分类
节点流：从特定的地方读写的流类，例如：磁盘或一块内存区域。
过滤流：使用节点流作为输入或输出。过滤流是使用一个已经存在的输入流或输出流连接创建的。

InputStream
三个基本的读方法
      abstract int read() ：读取一个字节数据，并返回读到的数据，如果返回-1，表示读到了输入流的末尾。
      int read(byte[]?b) ：将数据读入一个字节数组，同时返回实际读取的字节数。如果返回-1，表示读到了输入流的末尾。
      int read(byte[]?b, int?off, int?len) ：将数据读入一个字节数组，同时返回实际读取的字节数。如果返回-1，表示读到了输入流的末尾。off指定在数组b中存放数据的起始偏移位置；len指定读取的最大字节数。
其它方法
      long skip(long?n) ：在输入流中跳过n个字节，并返回实际跳过的字节数。
      int available() ：返回在不发生阻塞的情况下，可读取的字节数。
      void close() ：关闭输入流，释放和这个流相关的系统资源。
      void mark(int?readlimit) ：在输入流的当前位置放置一个标记，如果读取的字节数多于readlimit设置的值，则流忽略这个标记。
      void reset() ：返回到上一个标记。
      boolean markSupported() ：测试当前流是否支持mark和reset方法。如果支持，返回true，否则返回false。

OutputStream
三个基本的写方法
     abstract void write(int?b) ：往输出流中写入一个字节。
     void write(byte[]?b) ：往输出流中写入数组b中的所有字节。
     void write(byte[]?b, int?off, int?len) ：往输出流中写入数组b中从偏移量off开始的len个字节的数据。
其它方法
     void flush() ：刷新输出流，强制缓冲区中的输出字节被写出。
     void close() ：关闭输出流，释放和这个流相关的系统资源。



//StreamTest.java
package myStream;

public class StreamTest {
	public static void main(String[] args) {
		int data;
		try{
			while((data=System.in.read())!=-1)//从标准输入设备获取输入流
			{
				System.out.write(data);//输出到标准输出设备
			}
		}
		catch( Exception e ) {
			e.printStackTrace();
		}
	}
}

flaksd;fasd
flaksd;fasd
sdjfalsdkjf'asd
fsdjfalsdkjf'asd
asdjfalskdjfas
fasdjfalskdjfas
jasd;lkfja'sdf
jasd;lkfja'sdf
jalsdkfj
jalsdkfj
lksjdfa;l
lksjdfa;l
lkjafsd
lkjafsd
lkja'sdf
lkja'sdf


基本的流类
FileInputStream和FileOutputStream
    节点流，用于从文件中读取或往文件中写入字节流。如果在构造FileOutputStream时，文件已经存在，则覆盖这个文件。
BufferedInputStream和BufferedOutputStream
    过滤流，需要使用已经存在的节点流来构造，提供带缓冲的读写，提高了读写的效率。
DataInputStream和DataOutputStream
      过滤流，需要使用已经存在的节点流来构造，提供了读写Java中的基本数据类型的功能。
PipedInputStream和PipedOutputStream
    管道流，用于线程间的通信。一个线程的PipedInputStream对象从另一个线程的PipedOutputStream对象读取输入。要使管道流有用，必须同时构造管道输入流和管道输出流。

//StreamTest.java
package myStream;
import java.io.*;
public class StreamTest {
	public static void main(String[] args) {
		try{
			FileOutputStream fos=new FileOutputStream("1.txt");
			fos.write("http://zieckey.cubblog.cn".getBytes());
			fos.close();

			FileInputStream fis=new FileInputStream("1.txt");
			byte[] buf=new byte[100];
			int len=fis.read(buf);
			System.out.println(new String(buf,0,len));
		}
		catch( Exception e ){
			e.printStackTrace();
		}
	}
}

http://zieckey.cubblog.cn

利用内存缓冲区来实现：
//StreamTest.java
package myStream;
import java.io.*;
public class StreamTest {
	public static void main(String[] args) {
		try{
			FileOutputStream fos=new FileOutputStream("1.txt");
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			bos.write("http://zieckey.cubblog.cn".getBytes());
			bos.flush();	//写会硬盘，这里也可以利用	bos.close();，但是他们是有区别的
		}
		catch( Exception e ){
			e.printStackTrace();
		}
	}
}

//StreamTest.java
package myStream;
import java.io.*;
public class StreamTest {
	public static void main(String[] args) {
		try{
			FileOutputStream fos=new FileOutputStream("1.txt");
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			bos.write("http://zieckey.cubblog.cn".getBytes());
			bos.flush();

			FileInputStream fis=new FileInputStream("1.txt");
			BufferedInputStream bis = new BufferedInputStream( fis );
			byte[] buf=new byte[100];
			int len=bis.read(buf);
			System.out.println(new String(buf,0,len));
			bis.close();
		}
		catch( Exception e ){
			e.printStackTrace();
		}
	}
}

DataInputStream和DataOutputStream
      过滤流，需要使用已经存在的节点流来构造，提供了读写Java中的基本数据类型的功能。
//StreamTest.java
package myStream;
import java.io.*;
public class StreamTest {
	public static void main(String[] args) {
		try{
			FileOutputStream fos=new FileOutputStream("1.txt");
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			DataOutputStream dos = new DataOutputStream( bos );
			byte b=3;
			int i=78;
			char ch='a';
			float f=4.5f;
			dos.writeByte(b);
			dos.writeInt(i);
			dos.writeChar(ch);
			dos.writeFloat(f);
			dos.close();
		}
		catch( Exception e ){
			e.printStackTrace();
		}
	}
}

//StreamTest.java
package myStream;
import java.io.*;
public class StreamTest {
	public static void main(String[] args) {
		try{
			FileOutputStream fos=new FileOutputStream("1.txt");
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			DataOutputStream dos = new DataOutputStream( bos );
			byte b=3;
			int i=78;
			char ch='a';
			float f=4.5f;
			dos.writeByte(b);
			dos.writeInt(i);
			dos.writeChar(ch);
			dos.writeFloat(f);
			dos.close();

			FileInputStream fis=new FileInputStream("1.txt");
			BufferedInputStream bis=new BufferedInputStream(fis);
			DataInputStream dis=new DataInputStream(bis);
			System.out.println(dis.readByte());
			System.out.println(dis.readInt());
			System.out.println(dis.readChar());
			System.out.println(dis.readFloat());
			dis.close();

		}
		catch( Exception e ){
			e.printStackTrace();
		}
	}
}

3
78
a
4.5


PipedInputStream和PipedOutputStream
    管道流，用于线程间的通信。一个线程的PipedInputStream对象从另一个线程的PipedOutputStream对象读取输入。要使管道流有用，必须同时构造管道输入流和管道输出流。

package myPipeStream;
import java.io.*;
public class PipedStreamTest {
	public static void main(String[] args) {
		PipedOutputStream pos=new PipedOutputStream();
		PipedInputStream pis=new PipedInputStream();
		try
		{
			pos.connect(pis);
			new Producer(pos).start();
			new Consumer(pis).start();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}

class Producer extends Thread
{
	private PipedOutputStream pos;
	public Producer(PipedOutputStream pos)
	{
		this.pos=pos;
	}
	public void run()
	{
		try
		{
			pos.write("Hello,welcome you!".getBytes());
			pos.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}

class Consumer extends Thread
{
	private PipedInputStream pis;
	public Consumer(PipedInputStream pis)
	{
		this.pis=pis;
	}
	public void run()
	{
		try
		{
			byte[] buf=new byte[100];
			int len=pis.read(buf);
			System.out.println(new String(buf,0,len));
			pis.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}

Java I/O库的设计原则
Java的I/O库提供了一个称做链接的机制，可以将一个流与另一个流首尾相接，形成一个流管道的链接。这种机制实际上是一种被称为Decorator(装饰)设计模式的应用。
通过流的链接，可以动态的增加流的功能，而这种功能的增加是通过组合一些流的基本功能而动态获取的。
我们要获取一个I/O对象，往往需要产生多个I/O对象，这也是Java I/O库不太容易掌握的原因，但在I/O库中Decorator模式的运用，给我们提供了实现上的灵活性。

Reader和Writer
Java程序语言使用Unicode来表示字符串和字符。
Reader和Writer这两个抽象类主要用来读写字符流。

//StreamTest.java
package myStream;
import java.io.*;
public class StreamTest {
	public static void main(String[] args) {
		try{
			FileOutputStream fos=new FileOutputStream("1.txt");
			OutputStreamWriter osw=new OutputStreamWriter(fos);
			BufferedWriter bw=new BufferedWriter(osw);
			bw.write("http://zieckey.cublog.cn");//写入数据
			bw.close();

			FileInputStream fis=new FileInputStream("1.txt");
			InputStreamReader isr=new InputStreamReader(fis);
			BufferedReader br=new BufferedReader(isr);
			System.out.println(br.readLine());//读取数据并输出
			br.close();

		}
		catch( Exception e ){
			e.printStackTrace();
		}
	}
}
http://zieckey.cublog.cn


//StreamTest.java
package myStream;
import java.io.*;
public class StreamTest {
	public static void main(String[] args) {
		try{
			InputStreamReader isr=new InputStreamReader(System.in);
			BufferedReader br=new BufferedReader(isr);
			String strLine;
			while((strLine=br.readLine())!=null)
			{
				System.out.println(strLine);
			}
			br.close();
		}
		catch( Exception e ){
			e.printStackTrace();
		}
	}
}




字符集的编码ASCII(American Standard Code for Information Interchange，美国信息互换标准代码)，
是基于常用的英文字符的一套电脑编码系统。
我们知道英文中经常使用的字符、数字符号被计算机处理时都是以二进制码的形式出现的。
这种二进制码的集合就是所谓的ASCII码。每一个ASCII码与一个8位（bit）二进制数对应。
其最高位是0，相应的十进制数是0-127。如，数字“0”的编码用十进制数表示就是48。
另有128个扩展的ASCII码，最高位都是1，由一些制表符和其它符号组成。
ASCII是现今最通用的单字节编码系统。
GB2312：GB2312码是中华人民共和国国家汉字信息交换用编码，全称《信息交换用汉字编码字符集－基本集》。
主要用于给每一个中文字符指定相应的数字，也就是进行编码。
一个中文字符用两个字节的数字来表示，为了和ASCII码有所区别，将中文字符每一个字节的最高位置都用1来表示。
GBK：为了对更多的字符进行编码，国家又发布了新的编码系统GBK(GBK的K是“扩展”的汉语拼音第一个字母)。
在新的编码系统里，除了完全兼容GB2312 外，还对繁体中文、一些不常用的汉字和许多符号进行了编码。
ISO-8859-1：是西方国家所使用的字符编码集，是一种单字节的字符集 ，而英文实际上只用了其中数字小于128的部分。


Unicode：这是一种通用的字符集，对所有语言的文字进行了统一编码，对每一个字符都用2个字节来表示，
对于英文字符采取前面加“0”字节的策略实现等长兼容。如 “a” 的ASCII码为0x61，UNICODE就为0x00，0x61。
UTF-8：Eight-bit UCS Transformation Format，
(UCS，Universal Character Set，通用字符集，UCS 是所有其他字符集标准的一个超集)。
一个7位的ASCII码值，对应的UTF码是一个字节。
如果字符是0x0000，或在0x0080与0x007f之间，对应的UTF码是两个字节，
如果字符在0x0800与0xffff之间，对应的UTF码是三个字节。


查看当前系统支持的字符集：
package myCharset;
import java.util.*;
import java.nio.charset.*;
public class CharsetTest {
	public static void main(String[] args) {
		Map m=Charset.availableCharsets();
		Set names=m.keySet();
		Iterator it=names.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
	}

}
Big5
Big5-HKSCS
EUC-JP
EUC-KR
GB18030
GB2312
GBK
IBM-Thai
IBM00858
IBM01140
IBM01141
IBM01142
IBM01143
IBM01144
IBM01145
IBM01146
IBM01147
IBM01148
IBM01149
IBM037
IBM1026
IBM1047
IBM273
IBM277
IBM278
IBM280
IBM284
IBM285
IBM297
IBM420
IBM424
IBM437
IBM500
IBM775
IBM850
IBM852
IBM855
IBM857
IBM860
IBM861
IBM862
IBM863
IBM864
IBM865
IBM866
IBM868
IBM869
IBM870
IBM871
IBM918
ISO-2022-CN
ISO-2022-JP
ISO-2022-KR
ISO-8859-1
ISO-8859-13
ISO-8859-15
ISO-8859-2
ISO-8859-3
ISO-8859-4
ISO-8859-5
ISO-8859-6
ISO-8859-7
ISO-8859-8
ISO-8859-9
JIS_X0201
JIS_X0212-1990
KOI8-R
Shift_JIS
TIS-620
US-ASCII
UTF-16
UTF-16BE
UTF-16LE
UTF-8
windows-1250
windows-1251
windows-1252
windows-1253
windows-1254
windows-1255
windows-1256
windows-1257
windows-1258
windows-31j
x-Big5-Solaris
x-euc-jp-linux
x-EUC-TW
x-eucJP-Open
x-IBM1006
x-IBM1025
x-IBM1046
x-IBM1097
x-IBM1098
x-IBM1112
x-IBM1122
x-IBM1123
x-IBM1124
x-IBM1381
x-IBM1383
x-IBM33722
x-IBM737
x-IBM834
x-IBM856
x-IBM874
x-IBM875
x-IBM921
x-IBM922
x-IBM930
x-IBM933
x-IBM935
x-IBM937
x-IBM939
x-IBM942
x-IBM942C
x-IBM943
x-IBM943C
x-IBM948
x-IBM949
x-IBM949C
x-IBM950
x-IBM964
x-IBM970
x-ISCII91
x-ISO-2022-CN-CNS
x-ISO-2022-CN-GB
x-iso-8859-11
x-JIS0208
x-JISAutoDetect
x-Johab
x-MacArabic
x-MacCentralEurope
x-MacCroatian
x-MacCyrillic
x-MacDingbat
x-MacGreek
x-MacHebrew
x-MacIceland
x-MacRoman
x-MacRomania
x-MacSymbol
x-MacThai
x-MacTurkish
x-MacUkraine
x-MS950-HKSCS
x-mswin-936
x-PCK
x-windows-50220
x-windows-50221
x-windows-874
x-windows-949
x-windows-950
x-windows-iso2022jp

列出当前系统属性：
//CharsetTest.java
package myCharset;
import java.util.*;
import java.nio.charset.*;
public class CharsetTest {
	public static void main(String[] args) {
		Properties pps=System.getProperties();
		pps.list(System.out);
	}
}
-- listing properties --
java.runtime.name=Java(TM) 2 Runtime Environment, Stand...
sun.boot.library.path=C:\Program Files\Java\jre1.5.0_08\bin
java.vm.version=1.5.0_08-b03
java.vm.vendor=Sun Microsystems Inc.
java.vendor.url=http://java.sun.com/
path.separator=;
java.vm.name=Java HotSpot(TM) Client VM
file.encoding.pkg=sun.io
user.country=CN
sun.os.patch.level=Service Pack 2
java.vm.specification.name=Java Virtual Machine Specification
user.dir=E:\JavaLesson\Lesson9
java.runtime.version=1.5.0_08-b03
java.awt.graphicsenv=sun.awt.Win32GraphicsEnvironment
java.endorsed.dirs=C:\Program Files\Java\jre1.5.0_08\lib...
os.arch=x86
java.io.tmpdir=M:\DOCUME~1\apple\LOCALS~1\Temp\
line.separator=

java.vm.specification.vendor=Sun Microsystems Inc.
user.variant=
os.name=Windows XP
sun.jnu.encoding=GBK
java.library.path=C:\Program Files\Java\jre1.5.0_08\bin...
java.specification.name=Java Platform API Specification
java.class.version=49.0
sun.management.compiler=HotSpot Client Compiler
os.version=5.1
user.home=M:\Documents and Settings\apple
user.timezone=
java.awt.printerjob=sun.awt.windows.WPrinterJob
file.encoding=GBK
java.specification.version=1.5
user.name=apple
java.class.path=E:\JavaLesson\Lesson9\bin
java.vm.specification.version=1.0
sun.arch.data.model=32
java.home=C:\Program Files\Java\jre1.5.0_08
java.specification.vendor=Sun Microsystems Inc.
user.language=zh
awt.toolkit=sun.awt.windows.WToolkit
java.vm.info=mixed mode, sharing
java.version=1.5.0_08
java.ext.dirs=C:\Program Files\Java\jre1.5.0_08\lib...
sun.boot.class.path=C:\Program Files\Java\jre1.5.0_08\lib...
java.vendor=Sun Microsystems Inc.
file.separator=\
java.vendor.url.bug=http://java.sun.com/cgi-bin/bugreport...
sun.cpu.endian=little
sun.io.unicode.encoding=UnicodeLittle
sun.desktop=windows
sun.cpu.isalist=pentium_pro+mmx pentium_pro pentium+m...

上面的 file.encoding=GBK 就是当前系统的字符集默认编码



//CharsetTest.java
package myCharset;
import java.util.*;
import java.nio.charset.*;
public class CharsetTest {
	public static void main(String[] args) throws Exception {
		Properties pps=System.getProperties();
		pps.put("file.encoding","ISO-8859-1");//重新设置当前字符集的编码标准
		int data;
		byte[] buf=new byte[100];
		int i=0;
		while((data=System.in.read())!='q')//输入的字符是以ISO-8859-1编码字节存放在buf中,输入q结束
		{
			buf[i]=(byte)data;
			i++;
		}
		String str=new String(buf,0,i);
		System.out.println(str);//输出是以当前系统默认的字符集解码的，这里就是GBK

		//通过str.getBytes("ISO-8859-1")重新解码，然后以GBK编码
		String strGBK=new String(str.getBytes("ISO-8859-1"),"GBK");
		System.out.println(strGBK);//最后以默认编码格式解码，这样就得到了正确的结果
	}
}
你好啊q
你好啊
???

这里的程序结果与预想的不一致.不知道这个是什么问题?


InputStreamReader 是字节流通向字符流的桥梁：它使用指定的 charset 读取字节并将其解码为字符。它使用的字符集可以由名称指定或显式给定，否则可能接受平台默认的字符集。

OutputStreamWriter 是字符流通向字节流的桥梁：使用指定的 charset 将要向其写入的字符编码为字节。它使用的字符集可以由名称指定或显式给定，否则可能接受平台默认的字符集。

String(byte[] bytes, int offset, int length)
          构造一个新的 String，方法是使用指定的字符集解码字节的指定子数组。

没搞清楚字符集的问题!!



RandomAccessFile 类

RandomAccessFile类同时实现了DataInput和DataOutput接口，提供了对文件随机存取的功能，利用这个类可以在文件的任何位置读取或写入数据。
RandomAccessFile类提供了一个文件指针，用来标志要进行读写操作的下一数据的位置。


对文件进行读写都很方便。
对文件操作的例子：
//RandomAccessFileTest.java
import java.io.*;
class RandomAccessFileTest
{
	public static void main(String[] args) throws Exception
	{
		Student s1=new Student(200601,"zhangsan",88.5);
		Student s2=new Student(200602,"lisi",95);
		Student s3=new Student(200603,"wangwu",78);
		RandomAccessFile raf=new RandomAccessFile("student.txt","rw");//构造一个可读写的文件操作对象RandomAccessFile
		s1.writeStudent(raf);
		s2.writeStudent(raf);
		s3.writeStudent(raf);
		raf.close();
	}
}
class Student
{
	int num;
	String name;
	double score;
	public Student(int num,String name,double score)
	{
		this.num=num;
		this.name=name;
		this.score=score;
	}
	public void writeStudent(RandomAccessFile raf) throws IOException
	{
		raf.writeInt(num);//写入一个int类型的数据到raf相关的文件中
		raf.writeUTF(name);//以UTF-8格式写入字符串到文件中。
							//在开始写入数据前的两个字节记录了实际写入的数据的字节数
		raf.writeDouble(score);
	}
}
E:\zieckey\Lesson9>javac RandomAccessFileTest.java

E:\zieckey\Lesson9>java RandomAccessFileTest

E:\zieckey\Lesson9>

这个时候在E:\zieckey\Lesson9>目录下多了一个文件：student.txt
其内容如下：
 � zhangsan@V       � lisi@W�      � wangwu@S�
可以用UltraEdit查看该文件，对比看看写入的数据.

下面看看如何读取文件信息:
//RandomAccessFileTest.java
import java.io.*;
class RandomAccessFileTest
{
	public static void main(String[] args) throws Exception
	{
		Student s1=new Student(200601,"zhangsan",88.5);
		Student s2=new Student(200602,"lisi",95);
		Student s3=new Student(200603,"wangwu",78);
		RandomAccessFile raf=new RandomAccessFile("student.txt","rw");//构造一个可读写的文件操作对象RandomAccessFile
		s1.writeStudent(raf);
		s2.writeStudent(raf);
		s3.writeStudent(raf);//这里文件指针已经移动到文件末尾

		Student s=new Student();
		raf.seek(0);//下面要读取数据,就要将文件指针移动到文件开头
		for(long i=0;i<raf.length();i=raf.getFilePointer())
		{
			s.readStudent(raf);//每读取或写入一次数据,文件指针就随着移动
			System.out.println(s.num+":"+s.name+":"+s.score);
		}
		raf.close();
	}
}
class Student
{
	int num;
	String name;
	double score;
	public Student()
	{
	}
	public Student(int num,String name,double score)
	{
		this.num=num;
		this.name=name;
		this.score=score;
	}
	public void writeStudent(RandomAccessFile raf) throws IOException
	{
		raf.writeInt(num);//写入一个int类型的数据到raf相关的文件中
		raf.writeUTF(name);//以UTF-8格式写入字符串到文件中。
							//在开始写入数据前的两个字节记录了实际写入的数据的字节数
		raf.writeDouble(score);
	}
	public void readStudent(RandomAccessFile raf) throws IOException
	{
		num=raf.readInt();
		name=raf.readUTF();
		score=raf.readDouble();
	}
}

E:\zieckey\Lesson9>javac RandomAccessFileTest.java

E:\zieckey\Lesson9>java RandomAccessFileTest
200601:zhangsan:88.5
200602:lisi:95.0
200603:wangwu:78.0

与我们写入的信息是一样的.



对象序列化
将对象转换为字节流保存起来，并在日后还原这个对象，这种机制叫做对象序列化。
将一个对象保存到永久存储设备上称为持续性。
一个对象要想能够实现序列化，必须实现Serializable接口或Externalizable接口。

当一个对象被序列化时，只保存对象的非静态成员变量，不能保存任何的成员方法和静态的成员变量。
如果一个对象的成员变量是一个对象，那么这个对象的数据成员也会被保存。
如果一个可序列化的对象包含对某个不可序列化的对象的引用，那么整个序列化操作将会失败，并且会抛出一个NotSerializableException。我们可以将这个引用标记为transient，那么对象仍然可以序列化。
//ObjectSerialTest.java
import java.io.*;
class ObjectSerialTest
{
	public static void main(String[] args) throws Exception
	{
		Employee e1=new Employee("zhangsan",25,3000.50);
		Employee e2=new Employee("lisi",24,3200.40);
		Employee e3=new Employee("wangwu",27,3800.55);

		//写入序列化
		FileOutputStream fos=new FileOutputStream("employee.txt");
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		oos.writeObject(e1);
		oos.writeObject(e2);
		oos.writeObject(e3);
		oos.close();

		//读出序列化
		FileInputStream fis=new FileInputStream("employee.txt");
		ObjectInputStream ois=new ObjectInputStream(fis);
		Employee e;
		for(int i=0;i<3;i++)
		{
			e=(Employee)ois.readObject();
			System.out.println(e.name + ":" + e.age +  ":" + e.salary);
		}
		ois.close();
	}
}

class Employee implements Serializable
{
	String name;
	int age;
	double salary;
	public Employee(String name,int age,double salary)
	{
		this.name=name;
		this.age=age;
		this.salary=salary;
	}
}
E:\zieckey\Lesson9>javac ObjectSerialTest.java

E:\zieckey\Lesson9>java ObjectSerialTest
zhangsan:25:3000.5
lisi:24:3200.4
wangwu:27:3800.55

当一个对象被序列化时，只保存对象的非静态成员变量，不能保存任何的成员方法和静态的成员变量。
如果一个对象的成员变量是一个对象，那么这个对象的数据成员也会被保存。
如果一个可序列化的对象包含对某个不可序列化的对象的引用，那么整个序列化操作将会失败，并且会抛出一个NotSerializableException。我们可以将这个引用标记为transient，那么对象仍然可以序列化。
//ObjectSerialTest.java
import java.io.*;
class ObjectSerialTest
{
	public static void main(String[] args) throws Exception
	{
		Employee e1=new Employee("zhangsan",25,3000.50);
		Employee e2=new Employee("lisi",24,3200.40);
		Employee e3=new Employee("wangwu",27,3800.55);

		FileOutputStream fos=new FileOutputStream("employee.txt");
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		oos.writeObject(e1);
		oos.writeObject(e2);
		oos.writeObject(e3);
		oos.close();

		FileInputStream fis=new FileInputStream("employee.txt");
		ObjectInputStream ois=new ObjectInputStream(fis);
		Employee e;
		for(int i=0;i<3;i++)
		{
			e=(Employee)ois.readObject();
			System.out.println(e.name + ":" + e.age +  ":" + e.salary);
		}
		ois.close();
	}
}

class Employee implements Serializable
{
	String name;
	int age;
	double salary;
	Thread t=new Thread();
	public Employee(String name,int age,double salary)
	{
		this.name=name;
		this.age=age;
		this.salary=salary;
	}
}

E:\zieckey\Lesson9>javac ObjectSerialTest.java

E:\zieckey\Lesson9>java ObjectSerialTest
Exception in thread "main" java.io.NotSerializableException: java.lang.Thread
        at java.io.ObjectOutputStream.writeObject0(ObjectOutputStream.java:1075)

        at java.io.ObjectOutputStream.defaultWriteFields(ObjectOutputStream.java
:1369)
        at java.io.ObjectOutputStream.writeSerialData(ObjectOutputStream.java:13
41)
        at java.io.ObjectOutputStream.writeOrdinaryObject(ObjectOutputStream.jav
a:1284)
        at java.io.ObjectOutputStream.writeObject0(ObjectOutputStream.java:1073)

        at java.io.ObjectOutputStream.writeObject(ObjectOutputStream.java:291)
        at ObjectSerialTest.main(ObjectSerialTest.java:13)

E:\zieckey\Lesson9>

如果将Thread t=new Thread();声明为transient就不会出现错误
//ObjectSerialTest.java
import java.io.*;
class ObjectSerialTest
{
	public static void main(String[] args) throws Exception
	{
		Employee e1=new Employee("zhangsan",25,3000.50);
		Employee e2=new Employee("lisi",24,3200.40);
		Employee e3=new Employee("wangwu",27,3800.55);

		FileOutputStream fos=new FileOutputStream("employee.txt");
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		oos.writeObject(e1);
		oos.writeObject(e2);
		oos.writeObject(e3);
		oos.close();

		FileInputStream fis=new FileInputStream("employee.txt");
		ObjectInputStream ois=new ObjectInputStream(fis);
		Employee e;
		for(int i=0;i<3;i++)
		{
			e=(Employee)ois.readObject();
			System.out.println(e.name + ":" + e.age +  ":" + e.salary);
		}
		ois.close();
	}
}

class Employee implements Serializable
{
	String name;
	int age;
	double salary;
	transient Thread t=new Thread();
	public Employee(String name,int age,double salary)
	{
		this.name=name;
		this.age=age;
		this.salary=salary;
	}
}
E:\zieckey\Lesson9>javac ObjectSerialTest.java

E:\zieckey\Lesson9>java ObjectSerialTest
zhangsan:25:3000.5
lisi:24:3200.4
wangwu:27:3800.55

当我们想对序列化的信息进行额外的处理例如加密等操作时，我们必须实现如下两方法：
 private void writeObject(java.io.ObjectOutputStream out)
     throws IOException
 private void readObject(java.io.ObjectInputStream in)
     throws IOException, ClassNotFoundException;





import java.io.*;
class ObjectSerialTest
{
	public static void main(String[] args) throws Exception
	{
		Employee e1=new Employee("zhangsan",25,3000.50);
		Employee e2=new Employee("lisi",24,3200.40);
		Employee e3=new Employee("wangwu",27,3800.55);

		FileOutputStream fos=new FileOutputStream("employee.txt");
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		oos.writeObject(e1);
		oos.writeObject(e2);
		oos.writeObject(e3);
		oos.close();

		FileInputStream fis=new FileInputStream("employee.txt");
		ObjectInputStream ois=new ObjectInputStream(fis);
		Employee e;
		for(int i=0;i<3;i++)
		{
			e=(Employee)ois.readObject();
			System.out.println(e.name+":"+e.age+":"+e.salary);
		}
		ois.close();
	}
}

class Employee implements Serializable
{
	String name;
	int age;
	double salary;
	transient Thread t=new Thread();
	public Employee(String name,int age,double salary)2007-1-4 14:07
	{
		this.name=name;
		this.age=age;
		this.salary=salary;
	}
	private void writeObject(java.io.ObjectOutputStream oos) throws IOException
	{
		//没有写入薪水值
		oos.writeInt(age);
		oos.writeUTF(name);
		System.out.println("Write Object");
	}
	private void readObject(java.io.ObjectInputStream ois) throws IOException
	{
		age=ois.readInt();
		name=ois.readUTF();
		System.out.println("Read Object");
	}

}

E:\zieckey\Lesson9>javac ObjectSerialTest.java

E:\zieckey\Lesson9>java ObjectSerialTest
Write Object
Write Object
Write Object
Read Object
zhangsan:25:0.0
Read Object
lisi:24:0.0
Read Object
wangwu:27:0.0

E:\zieckey\Lesson9>

这里的
 private void writeObject(java.io.ObjectOutputStream out)
     throws IOException
 private void readObject(java.io.ObjectInputStream in)
     throws IOException, ClassNotFoundException;
这两个静态方法是个特例，在类的外部都可以被调用。









总结
InputStream和OutputStream：字节流的输入输出。
Reader和Writer：字符流的输入输出。
流的链接(Java I/O库的设计原则)









Lesson10
图形界面开发
AWT
AWT(Abstract Window Toolkit)，抽象窗口工具包，SUN公司提供的用于图形界面编程(GUI)的类库。基本的AWT库处理用户界面元素的方法是把这些元素的创建和行为委托给每个目标平台上（Windows、Unix、Macintosh等）的本地GUI工具进行处理。例如：如果我们使用AWT在一个Java窗口中放置一个按钮，那么实际上使用的是一个具有本地外观和感觉的按钮。这样，从理论上来说，我们所编写的图形界面程序能运行在任何平台上，做到了图形界面程序的跨平台运行。

布局管理器
容器里组件的位置和大小是由布局管理器来决定的。容器对布局管理器的特定实例保持一个引用。当容器需要定位一个组件时，它将调用布局管理器来完成。当决定一个组件的大小时，也是如此。
在AWT中，给我们提供了五种布局管理器：
	BorderLayout
    FlowLayout
    GridLayout
    CardLayout
    GridBagLayout

//MyFrameTest.java
package frametest;
import java.awt.*;
public class MyFrameTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Frame myFrame = new Frame( "zieckey" );
		myFrame.setSize( 640, 480 );//设置窗口大小
		myFrame.setLocation( 100, 100 );//设置窗口显示的位置为（100，100）
		myFrame.setBackground( Color.blue );//设置颜色

		//创建按钮,并确定按钮上面显示的字符串
	    Button btn1=new Button("zieckey North");
	    Button btn2=new Button("zieckey South");
	    Button btn3=new Button("West");
	    Button btn4=new Button("East");
	    Button btn5=new Button("Center");

	    //将按钮添加到窗口上并确定在窗口上显示的位置
	    myFrame.add( btn1,"North" );
	    myFrame.add( btn2,"South" );
	    myFrame.add( btn3,"West" );
	    myFrame.add( btn4,"East" );
	    myFrame.add( btn5,"Center" );

	    myFrame.setVisible( true );//显示窗口

	}
}

在窗口上东、南、西、北、中分别显示了5个按钮，
中间的安扭长宽大小都可变，南北的高度始终不变，左右的宽度始终不变
//MyFrameTest.java
package frametest;
import java.awt.*;
public class MyFrameTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Frame myFrame = new Frame( "zieckey" );
		myFrame.setSize( 640, 480 );//设置窗口大小
		myFrame.setLocation( 100, 100 );//设置窗口显示的位置为（100，100）
		myFrame.setBackground( Color.blue );//设置颜色

		myFrame.setLayout(new BorderLayout(10,10));//重新设置布局管理器

		//创建按钮,并确定按钮上面显示的字符串
	    Button btn1=new Button("zieckey North");
	    Button btn2=new Button("zieckey South");
	    Button btn3=new Button("West");
	    Button btn4=new Button("East");
	    Button btn5=new Button("Center");

	    //将按钮添加到窗口上并确定在窗口上显示的位置
	    myFrame.add( btn1,"North" );
	    myFrame.add( btn2,"South" );
	    myFrame.add( btn3,"West" );
	    myFrame.add( btn4,"East" );
	    myFrame.add( btn5,"Center" );
	    myFrame.setVisible( true );//显示窗口
	}
}


//MyFrameTest.java
package frametest;
import java.awt.*;
public class MyFrameTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Frame myFrame = new Frame( "zieckey" );
		myFrame.setSize( 640, 480 );//设置窗口大小
		myFrame.setLocation( 100, 100 );//设置窗口显示的位置为（100，100）
		myFrame.setBackground( Color.blue );//设置颜色

		//myFrame.setLayout(new FlowLayout(FlowLayout.LEFT));//重新设置布局管理器
		//myFrame.setLayout(new BorderLayout(10,10));
		myFrame.setLayout(new GridLayout(3,2,10,10));

		//创建按钮,并确定按钮上面显示的字符串
	    Button btn1=new Button("zieckey North");
	    Button btn2=new Button("zieckey South");
	    Button btn3=new Button("West");
	    Button btn4=new Button("East");
	    Button btn5=new Button("Center");

	    //将按钮添加到窗口上并确定在窗口上显示的位置
	    myFrame.add( btn1,"North" );
	    myFrame.add( btn2,"South" );
	    myFrame.add( btn3,"West" );
	    myFrame.add( btn4,"East" );
	    myFrame.add( btn5,"Center" );
	    myFrame.setVisible( true );//显示窗口
	}
}


AWT事件模型
Events(事件)：描述发生了什么的对象。
Event source(事件源)：事件的产生器。
Event handlers(事件处理器)：接收事件对象、解释事件对象并处理用户交互的方法。
//MyFrameTest.java
package frametest;
import java.awt.*;
import java.awt.event.*;
public class MyFrameTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Frame myFrame = new Frame( "zieckey" );
		myFrame.setSize( 640, 480 );//设置窗口大小
		myFrame.setLocation( 100, 100 );//设置窗口显示的位置为（100，100）
		myFrame.setBackground( Color.blue );//设置颜色

		//myFrame.setLayout(new FlowLayout(FlowLayout.LEFT));//重新设置布局管理器
		//myFrame.setLayout(new BorderLayout(10,10));
		myFrame.setLayout(new GridLayout(3,2,10,10));

		//创建按钮,并确定按钮上面显示的字符串
	    Button btn1=new Button("zieckey North");
	    Button btn2=new Button("zieckey South");
	    Button btn3=new Button("West");
	    Button btn4=new Button("East");
	    Button btn5=new Button("Center");

	    //将按钮添加到窗口上并确定在窗口上显示的位置
	    myFrame.add( btn1,"North" );
	    myFrame.add( btn2,"South" );
	    myFrame.add( btn3,"West" );
	    myFrame.add( btn4,"East" );
	    myFrame.add( btn5,"Center" );

	    myFrame.addWindowListener( new MyWindowListener() );//添加一个事件监听器

	    myFrame.setVisible( true );//显示窗口
	}
}

class MyWindowListener implements WindowListener
{
  public void windowOpened(WindowEvent e)
  {

  }
  public void windowClosing(WindowEvent e)
  {
    System.exit(0);
  }
  public void windowClosed(WindowEvent e)
  {
  }
  public void windowIconified(WindowEvent e)
  {

  }
  public void windowDeiconified(WindowEvent e)
  {

  }
  public void windowActivated(WindowEvent e)
  {

  }
  public void windowDeactivated(WindowEvent e)
  {

  }
}

这里为了实现一个程序退出功能，要实现WindowListener接口，
真的很麻烦。

我们可以从 WindowAdapter 派生一个类，然后实现我们需要的功能就可以了。
WindowAdapter 类实现了所有WindowListener接口的函数，但是它是空实现。
//MyFrameTest.java
package frametest;
import java.awt.*;
import java.awt.event.*;
public class MyFrameTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Frame myFrame = new Frame( "zieckey" );
		myFrame.setSize( 640, 480 );//设置窗口大小
		myFrame.setLocation( 100, 100 );//设置窗口显示的位置为（100，100）
		myFrame.setBackground( Color.blue );//设置颜色

		//myFrame.setLayout(new FlowLayout(FlowLayout.LEFT));//重新设置布局管理器
		//myFrame.setLayout(new BorderLayout(10,10));
		myFrame.setLayout(new GridLayout(3,2,10,10));

		//创建按钮,并确定按钮上面显示的字符串
	    Button btn1=new Button("zieckey North");
	    Button btn2=new Button("zieckey South");
	    Button btn3=new Button("West");
	    Button btn4=new Button("East");
	    Button btn5=new Button("Center");

	    //将按钮添加到窗口上并确定在窗口上显示的位置
	    myFrame.add( btn1,"North" );
	    myFrame.add( btn2,"South" );
	    myFrame.add( btn3,"West" );
	    myFrame.add( btn4,"East" );
	    myFrame.add( btn5,"Center" );

	    //myFrame.addWindowListener( new MyWindowListener() );//添加一个事件监听器
	    myFrame.addWindowListener( new HisWindowListener() );//添加一个事件监听器

	    myFrame.setVisible( true );//显示窗口
	}
}

class MyWindowListener implements WindowListener
{
  public void windowOpened(WindowEvent e)
  {

  }
  public void windowClosing(WindowEvent e)
  {
    System.exit(0);
  }
  public void windowClosed(WindowEvent e)
  {
  }
  public void windowIconified(WindowEvent e)
  {

  }
  public void windowDeiconified(WindowEvent e)
  {

  }
  public void windowActivated(WindowEvent e)
  {

  }
  public void windowDeactivated(WindowEvent e)
  {

  }
}
class HisWindowListener extends WindowAdapter
{
  public void windowClosing(WindowEvent e)
  {
    System.exit(0);
  }
}

或者添加一个匿名的内部类：

//MyFrameTest.java
package frametest;
import java.awt.*;
import java.awt.event.*;
public class MyFrameTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Frame myFrame = new Frame( "zieckey" );
		myFrame.setSize( 640, 480 );//设置窗口大小
		myFrame.setLocation( 100, 100 );//设置窗口显示的位置为（100，100）
		myFrame.setBackground( Color.blue );//设置颜色

		//myFrame.setLayout(new FlowLayout(FlowLayout.LEFT));//重新设置布局管理器
		//myFrame.setLayout(new BorderLayout(10,10));
		myFrame.setLayout(new GridLayout(3,2,10,10));

		//创建按钮,并确定按钮上面显示的字符串
	    Button btn1=new Button("zieckey North");
	    Button btn2=new Button("zieckey South");
	    Button btn3=new Button("West");
	    Button btn4=new Button("East");
	    Button btn5=new Button("Center");

	    //将按钮添加到窗口上并确定在窗口上显示的位置
	    myFrame.add( btn1,"North" );
	    myFrame.add( btn2,"South" );
	    myFrame.add( btn3,"West" );
	    myFrame.add( btn4,"East" );
	    myFrame.add( btn5,"Center" );

	    //myFrame.addWindowListener( new MyWindowListener() );//添加一个事件监听器
	    //myFrame.addWindowListener( new HisWindowListener() );//添加一个事件监听器
	    myFrame.addWindowListener(new WindowAdapter()
						        {
									  public void windowClosing(WindowEvent e)
									  {
									    System.exit(0);
									  }
						        });

	    myFrame.setVisible( true );//显示窗口
	}
}

class MyWindowListener implements WindowListener
{
  public void windowOpened(WindowEvent e)
  {

  }
  public void windowClosing(WindowEvent e)
  {
    System.exit(0);
  }
  public void windowClosed(WindowEvent e)
  {
  }
  public void windowIconified(WindowEvent e)
  {

  }
  public void windowDeiconified(WindowEvent e)
  {

  }
  public void windowActivated(WindowEvent e)
  {

  }
  public void windowDeactivated(WindowEvent e)
  {

  }
}
class HisWindowListener extends WindowAdapter
{
  public void windowClosing(WindowEvent e)
  {
    System.exit(0);
  }
}






package layouttest;

import java.awt.*;
import java.awt.event.*;

public class YourFrame extends Frame
{
  private Panel borderPanel;
  private Panel flowPanel;
  private Panel gridPanel;
  private Panel cardPanel;
  public YourFrame(String title)
  {
    super(title);
    setSize(600,400);
    setLocation(100,100);
    setBorderLayoutPanel();
    setFlowLayoutPanel();
    setGridLayoutPanel();
    setCardLayoutPanel();
    setLayout(new GridLayout(2,2));
    add(borderPanel);
    add(flowPanel);
    add(gridPanel);
    add(cardPanel);
    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
  }

  public void setBorderLayoutPanel()
  {
    borderPanel=new Panel();
    borderPanel.setLayout(new BorderLayout());
    Button btn1=new Button("North");
    Button btn2=new Button("South");
    Button btn3=new Button("West");
    Button btn4=new Button("East");
    Button btn5=new Button("Center");
    borderPanel.add(btn1,BorderLayout.NORTH);
    borderPanel.add(btn2,BorderLayout.SOUTH);
    borderPanel.add(btn3,BorderLayout.WEST);
    borderPanel.add(btn4,BorderLayout.EAST);
    borderPanel.add(btn5,BorderLayout.CENTER);
  }
  public void setFlowLayoutPanel()
  {
    flowPanel=new Panel();
    Button btn1=new Button("mybole");
    btn1.addActionListener(new ActionListener() {//响应鼠标点击事件后更换按钮文本
           public void actionPerformed(ActionEvent e) {
             ((Button)e.getSource()).setLabel("weixin");
           }
         });
    Button btn2=new Button("winsun");
    flowPanel.add(btn1);
    flowPanel.add(btn2);
  }
  public void setGridLayoutPanel()
  {
    gridPanel=new Panel();
    gridPanel.setLayout(new GridLayout(2,2));
    Button btn1=new Button("Button1");
    Button btn2=new Button("Button2");
    Button btn3=new Button("Button3");
    Button btn4=new Button("Button4");
    gridPanel.add(btn1);
    gridPanel.add(btn2);
    gridPanel.add(btn3);
    gridPanel.add(btn4);
  }
  public void setCardLayoutPanel()
  {
    final CardLayout cl=new CardLayout();
    cardPanel=new Panel();
    cardPanel.setLayout(cl);
    Button btn1=new Button("黑桃A");
    Button btn2=new Button("红桃K");
    ActionListener al=new ActionListener()//实现一个翻牌的效果
        {
          public void actionPerformed(ActionEvent e)
          {
            cl.next( cardPanel );
          }
        };

    btn1.addActionListener(al);
    btn2.addActionListener(al);

    cardPanel.add(btn1,"1");
    cardPanel.add(btn2,"2");
  }
  public static void main(String[] args) throws HeadlessException
  {
    YourFrame yf = new YourFrame("http://www.mybole.com.cn");
    yf.setVisible( true );
  }

}



菜单栏创建：
/**
 *
 */
package menutest;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author apple
 */
public class MenuFrame
{

	/**
	 * @param args
	 */
	@SuppressWarnings ( "deprecation" )
	public static void main ( String[] args )
	{
		final Frame f = new Frame ( "http://zieckey.cublog.cn" );
		f.setSize ( 600 , 400 );
		f.setLocation ( 100 , 100 );

		// 响应关闭按钮的信号
		f.addWindowListener ( new WindowAdapter ( )
			{
				public void windowClosing ( WindowEvent e )
				{
					System.exit ( 0 );
				}
			} );

		MenuBar mb = new MenuBar ( );
		Menu m1 = new Menu ( "File" );
		Menu m2 = new Menu ( "Edit" );
		MenuItem mi1 = new MenuItem ( "New" );
		MenuItem mi2 = new MenuItem ( "Open" );
		MenuItem mi3 = new MenuItem ( "Save" );
		MenuItem mi4 = new MenuItem ( "Exit" );
		MenuItem mi5 = new MenuItem ( "Copy" );
		MenuItem mi6 = new MenuItem ( "Paste" );

		// 响应退出菜单的事件
		mi4.addActionListener ( new ActionListener ( )
			{
				public void actionPerformed ( ActionEvent arg0 )
				{
					System.exit ( 0 );
				}
			} );

		// 将菜单项添加到菜单中
		m1.add ( mi1 );
		m1.add ( mi2 );
		m1.add ( mi3 );
		m1.add ( mi4 );
		m2.add ( mi5 );
		m2.add ( mi6 );

		// 将各个菜单添加到菜单栏中
		mb.add ( m1 );
		mb.add ( m2 );

		// 将菜单栏添加到主窗口中
		f.setMenuBar ( mb );

		f.setVisible ( true );
	}
}

匿名类要访问局部变量，要将这个变量声明为final

响应菜单项，打开文件对话框，显示文本到编辑区域
/**
 *
 */
package menutest;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;

/**
 * @author apple
 */
public class MenuFrame
{

	/**
	 * @param args
	 */
	@SuppressWarnings ( "deprecation" )
	public static void main ( String[] args )
	{
		final Frame f = new Frame ( "http://zieckey.cublog.cn" );
		f.setSize ( 600 , 400 );
		f.setLocation ( 100 , 100 );

		final TextArea ta = new TextArea();//构造一个输入区域
		f.add ( ta );

		// 响应关闭按钮的信号
		f.addWindowListener ( new WindowAdapter ( )
			{
				public void windowClosing ( WindowEvent e )
				{
					System.exit ( 0 );
				}
			} );

		MenuBar mb = new MenuBar ( );
		Menu m1 = new Menu ( "File" );
		Menu m2 = new Menu ( "Edit" );
		MenuItem mi1 = new MenuItem ( "New" );
		MenuItem mi2 = new MenuItem ( "Open" );
		MenuItem mi3 = new MenuItem ( "Save" );
		MenuItem mi4 = new MenuItem ( "Exit" );
		MenuItem mi5 = new MenuItem ( "Copy" );
		MenuItem mi6 = new MenuItem ( "Paste" );

		// 响应Open退出菜单的事件
		mi2.addActionListener ( new ActionListener ( )
			{
				public void actionPerformed ( ActionEvent arg0 )
				{
					//构造一个打开文件对话框
					FileDialog fd = new FileDialog ( f,
							"zieckey Open File Dialog", FileDialog.LOAD );
					fd.setVisible ( true );//将其显示出来

					//得到用户选择的文件名全称
					String fileName = fd.getDirectory ( ) +  fd.getFile ( ) ;
					if ( fileName != null )
					{
						try
						{
							FileInputStream fis=new FileInputStream(fileName);//构造一个文件输入流
							byte[] buf=new byte[10*1024];
							int len=fis.read(buf);//读取数据到buf中
							ta.append ( new String(buf,0,len) );//将buf中数据添加到文本输入区域
							fis.close ( );
						}
						catch ( Exception e )
						{
							e.printStackTrace ( );
						}
					} else
					{

					}
				}

			} );

		// 响应Exit退出菜单的事件
		mi4.addActionListener ( new ActionListener ( )
			{
				public void actionPerformed ( ActionEvent arg0 )
				{
					System.exit ( 0 );
				}
			} );

		// 将菜单项添加到菜单中
		m1.add ( mi1 );
		m1.add ( mi2 );
		m1.add ( mi3 );
		m1.add ( mi4 );
		m2.add ( mi5 );
		m2.add ( mi6 );

		// 将各个菜单添加到菜单栏中
		mb.add ( m1 );
		mb.add ( m2 );

		// 将菜单栏添加到主窗口中
		f.setMenuBar ( mb );

		f.setVisible ( true );
	}
}


Lesson11
Applet

Applet又称为Java小应用程序，是能够嵌入到一个HTML页面中，并且可通过Web浏览器下载和执行的一种Java类 。
Applet不需要main()方法，由Web浏览器中内嵌的Java虚拟机调用执行。

因为applet是从远端服务器上下载并且在本地执行，所以安全性就显得格外重要。
通过限制applet在沙箱(applet的运行环境)中运行，保证了对本地系统而言applet是安全的。
applet在沙箱中运行时：
⑴不能运行任何本地可执行程序；
⑵除了存放下载的applet的服务器外，applet不能和其它主机进行通信。
⑶不能对本地文件系统进行读写。

Applet的生命周期
init()：当浏览器加载applet，进行初始化的时候调用该方法。
start()：在init()方法之后调用。当用户从其它页面转到包含applet的页面时，该方法也被调用。
stop()：在用户离开包含applet的页面时被调用。
destroy()：当applet不再被使用，或浏览器退出的时候，该方法被调用。

paint()方法
Applet本质上是图形方式的，我们应该在图形环境中绘制我们的显示内容。
我们可以通过创建一个paint()方法在Applet的panel上绘图。只要Applet的显示需要刷新，paint()方法就会被浏览器环境调用。例如，当Applet的显示尺寸发生变化的时候，或浏览器窗口被最小化或被要求以图标方式显示时，这种调用就会发生。
我们应该编写自己的paint()方法，以使它在任何时候被调用，都能正常地工作。对它的调用是异步产生的，且由Applet的运行环境而不是程序来驱动 。
paint()方法带有一个参数，它是java.awt.Graphics类的一个实例。这个参数总是建立该Applet的panel的图形上下文，我们可以用这个图形上下文在Applet中绘图或写入文本。


//AppletTest.java
package applettest;

import java.applet.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.net.URL;
public class AppletTest extends Applet
{
	/**
	 *
	 */
	private static final long	serialVersionUID	= 1L;
	String strFont;//字体
	public void init()
	{
		strFont=getParameter("font");//从网页中获取定义的字体信息
		System.out.println("init");
	}
	public void start()
	{
		System.out.println("start");
	}
	public void stop()
	{
		System.out.println("stop");
	}
	public void destroy()
	{
		System.out.println("destroy");
	}
	public void paint(Graphics g)
	{
		//Font f=new Font("楷体_GB2312",Font.BOLD,30);
		Font f=new Font(strFont,Font.BOLD,30);
		g.setFont(f);//设置字体
		g.setColor(Color.blue);//设置字体颜色
		g.drawString("zieckey学Java",0,30);//在网页上显示信息
	}
}

/*这里是进行html网页进行测试用的
<applet code="TestApplet.class" width=600 height=400>
<param name="font" value="楷体_GB2312">
</applet>
*/




//AppletTest.java
package applettest;
import java.applet.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AppletTest extends Applet
{
	/**
	 *
	 */
	private static final long	serialVersionUID	= 1L;
	String strFont;//字体
	int xOrigin,yOrigin;
	public void init()
	{
		//在Applet中实现鼠标画线功能
		addMouseListener(new MouseAdapter()
		{
			public void mousePressed(MouseEvent e)
			{
				xOrigin=e.getX();
				yOrigin=e.getY();
			}
			public void mouseReleased(MouseEvent e)
			{
				Graphics g=getGraphics();
				g.setColor(Color.red);
				g.drawLine(xOrigin,yOrigin,e.getX(),e.getY());
			}
		});
		strFont=getParameter("font");//从网页中获取定义的字体信息
		System.out.println("init");
	}
	public void start()
	{
		System.out.println("start");
	}
	public void stop()
	{
		System.out.println("stop");
	}
	public void destroy()
	{
		System.out.println("destroy");
	}
	public void paint(Graphics g)
	{
		//Font f=new Font("楷体_GB2312",Font.BOLD,30);
		Font f=new Font(strFont,Font.BOLD,30);
		g.setFont(f);//设置字体
		g.setColor(Color.blue);//设置字体颜色
		g.drawString("zieckey学Java",0,30);//在网页上显示信息
	}
}

/*这里是进行html网页进行测试用的
<applet code="TestApplet.class" width=600 height=400>
<param name="font" value="楷体_GB2312">
</applet>
*/


//AppletTest.java
package applettest;
import java.applet.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

public class AppletTest extends Applet
{
	/**
	 *
	 */
	private static final long	serialVersionUID	= 1L;
	String strFont;//字体
	int xOrigin,yOrigin;
	public void init()
	{
		//添加一个按钮
		Button btn=new Button("链接");
		add(btn);
		btn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					getAppletContext().showDocument(
						new URL("http://zieckey.cublog.cn"),"_blank");
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
			}
		});

		//在Applet中实现鼠标画线功能
		addMouseListener(new MouseAdapter()
		{
			public void mousePressed(MouseEvent e)
			{
				xOrigin=e.getX();
				yOrigin=e.getY();
			}
			public void mouseReleased(MouseEvent e)
			{
				Graphics g=getGraphics();
				g.setColor(Color.red);
				g.drawLine(xOrigin,yOrigin,e.getX(),e.getY());
			}
		});
		strFont=getParameter("font");//从网页中获取定义的字体信息
		System.out.println("init");
	}
	public void start()
	{
		System.out.println("start");
	}
	public void stop()
	{
		System.out.println("stop");
	}
	public void destroy()
	{
		System.out.println("destroy");
	}
	public void paint(Graphics g)
	{
		//Font f=new Font("楷体_GB2312",Font.BOLD,30);
		Font f=new Font(strFont,Font.BOLD,30);
		g.setFont(f);//设置字体
		g.setColor(Color.blue);//设置字体颜色
		g.drawString("zieckey学Java",0,30);//在网页上显示信息
	}
}
这里注意要清除类载入程序高速缓存，打开Java控制台，按x键就可以了
但是这里没有像想象中的那样出现按钮。









Lesson12
网络编程
基于TCP的socket编程
服务器程序编写：
①调用ServerSocket(int port)创建一个服务器端套接字，并绑定到指定端口上；
②调用accept()，监听连接请求，如果客户端请求连接，则接受连接，返回通信套接字。
③调用Socket类的getOutputStream()和getInputStream获取输出流和输入流，开始网络数据的发送和接收。
④最后关闭通信套接字。
客户端程序编写：
①调用Socket()创建一个流套接字，并连接到服务器端； 
②调用Socket类的getOutputStream()和getInputStream获取输出流和输入流，开始网络数据的发送和接收。
③最后关闭通信套接字。

在Eclipse中添加参数运行:
点run 边上的下垃铵钮再点run，然后点new 你要运行的类，main选好后，点main边上的Arguments，
然后在Program arguments里写上你要带的参数后再运行。

下面是一个最简单的TCP的socket应用程序:

// TestTCPConnection.java
package tcptest;

import java.net.*;
import java.io.*;

public class TestTCPConnection
{

	private static final int	PORT	= 6000;

	/**
	 * @param args
	 */
	public static void main ( String[] args )
	{
		if ( args.length > 0 ) // 如果有参数输入就启动服务器程序
			server ( );
		else
			// 否则启动客户端进程
			client ( );
	}


	public static void server ()
	{
		System.out.println ( "This is server" );
		try
		{
			ServerSocket ss = new ServerSocket ( PORT );
			Socket s = ss.accept ( );
			OutputStream os = s.getOutputStream ( );
			InputStream is = s.getInputStream ( );
			os.write ( "Hello,welcome you!".getBytes ( ) );
			byte[] buf = new byte[100];
			int len = is.read ( buf );
			System.out.println ( new String ( buf, 0, len ) );
			os.close ( );
			is.close ( );
			s.close ( );
			ss.close ( );
		} catch ( Exception ex )
		{
			ex.printStackTrace ( );
		}
	}

	public static void client ()
	{
		System.out.println ( "This is client" );
		try
		{
			Socket s = new Socket ( InetAddress.getByName ( null ), PORT );
			OutputStream os = s.getOutputStream ( );
			InputStream is = s.getInputStream ( );
			byte[] buf = new byte[100];
			int len = is.read ( buf );
			System.out.println ( new String ( buf, 0, len ) );
			os.write ( "Hello,this is wangwu".getBytes ( ) );
			os.close ( );
			is.close ( );
			s.close ( );
		} catch ( Exception ex )
		{
			ex.printStackTrace ( );
		}
	}
}


让服务器创建多线程为客户端进行连接:
// TestTCPConnection.java
package tcptest;

import java.net.*;
import java.io.*;

/**
 * 一个简单的多线程服务器程序
 *
 * @author apple
 */
public class TestTCPConnection extends Thread
{
	private static final int	PORT	= 6000;
	private Socket				s;

	public TestTCPConnection ( Socket s )
	{
		this.s = s;
	}

	@Override
	public void run ()
	{
		try
		{
			OutputStream os = s.getOutputStream ( );
			InputStream is = s.getInputStream ( );
			os.write ( "Hello,welcome you!".getBytes ( ) );
			byte[] buf = new byte[100];
			int len = is.read ( buf );
			System.out.println ( new String ( buf, 0, len ) );
			os.close ( );
			is.close ( );
			s.close ( );
		} catch ( Exception e )
		{
			e.printStackTrace ( );
		}

	}

	/**
	 * @param args
	 */
	public static void main ( String[] args )
	{
		if ( args.length > 0 ) // 如果有参数输入就启动服务器程序
			server ( );
		else
			// 否则启动客户端进程
			client ( );
	}

	public static void server ()
	{
		System.out.println ( "This is server" );
		try
		{
			ServerSocket ss = new ServerSocket ( PORT );
			int count = 0;
			while ( true )
			{
				// 创建一个Socket等待客户端连接
				Socket s = ss.accept ( );
				System.out.println ( "This is the " + count++
									+ "st client connetion!" );
				new TestTCPConnection ( s ).start ( );// 启动一个线程为这个客户端服务
			}
		} catch ( Exception ex )
		{
			ex.printStackTrace ( );
		}
	}

	public static void client ()
	{
		System.out.println ( "This is client" );
		try
		{
			// 创建一个Socket
			Socket s = new Socket ( InetAddress.getByName ( null ), PORT );
			OutputStream os = s.getOutputStream ( );// 输出流
			InputStream is = s.getInputStream ( );// 输入流
			byte[] buf = new byte[100];
			int len = is.read ( buf );// 从输入流中读取数据到buf
			System.out.println ( new String ( buf, 0, len ) );
			// 向输出流中写入数据
			os.write ( "Hello,this is zhangsan".getBytes ( ) );
			os.close ( );
			is.close ( );
			s.close ( );
		} catch ( Exception ex )
		{
			ex.printStackTrace ( );
		}
	}
}



数据报UDP编程:

// TestTCPConnection.java
package tcptest;

import java.net.*;
/**
 * 一个简单的多线程服务器程序
 *
 * @author apple
 */
public class TestUDPConnection
{
	private static final int	PORT	= 6000;

	public static void main ( String[] args )
	{
		if ( args.length > 0 )
			recv ( );
		else
			send ( );
	}

	public static void recv ()//接收方扮演服务器
	{
		try
		{
			DatagramSocket ds = new DatagramSocket ( PORT );
			byte[] buf = new byte[100];
			DatagramPacket dp = new DatagramPacket ( buf, 100 );
			ds.receive ( dp );//等待数据的到来
			System.out.println ( new String ( buf, 0, dp.getLength ( ) ) );
			//接收到信息后回复一个数据给发送方
			String str = "Welcome you!";
			DatagramPacket dpSend = new DatagramPacket ( str.getBytes ( ), str
								.length ( ), dp.getAddress ( ), dp.getPort ( ) );
			ds.send ( dpSend );
			ds.close ( );
		} catch ( Exception ex )
		{
			ex.printStackTrace ( );
		}
	}

	public static void send ()
	{
		try
		{
			DatagramSocket ds = new DatagramSocket ( );
			String str = "Hello,this is zhangsan";
			DatagramPacket dp = new DatagramPacket ( str.getBytes ( ), str
								.length ( ), InetAddress
								.getByName ( "localhost" ), 6000 );
			ds.send ( dp );//发送数据到接收方
			byte[] buf = new byte[100];
			DatagramPacket dpRecv = new DatagramPacket ( buf, 100 );
			ds.receive ( dpRecv );//等待接收方的回应信息
			System.out.println ( new String ( buf, 0, dpRecv.getLength ( ) ) );
			ds.close ( );
		} catch ( Exception ex )
		{
			ex.printStackTrace ( );
		}
	}
}



写个简单的网络下载程序:
package down;

import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

public class Download
{
	public static void main ( String[] args )
	{
		// 构造一个窗口
		JFrame jf = new JFrame ( "下载程序" );
		jf.setSize ( 600, 400 );
		jf.setLocation ( 100, 100 );
		JPanel p = new JPanel ( );// 构造一个面板
		JLabel l = new JLabel ( "Please input URL:" );
		final JTextField tf = new JTextField ( 30 );
		p.add ( l );
		p.add ( tf );
		jf.getContentPane ( ).add ( p, "North" );// 将面板添加到窗口中
		final JTextArea ta = new JTextArea ( );
		jf.getContentPane ( ).add ( ta, "Center" );
		JButton btn = new JButton ( "Download" );
		jf.getContentPane ( ).add ( btn, "South" );
		btn.addActionListener ( new ActionListener ( )// 添加按钮响应信息
					{
						public void actionPerformed ( ActionEvent e )
						{
							String str = tf.getText ( );
							try
							{
								URL url = new URL ( str );// 获取到用户输入的URL
								// 对该URL连接
								URLConnection urlConn = url.openConnection ( );
								// 获取与平台无关的行分隔符
								String line = System
										.getProperty ( "line.separator" );
								// 得到该连接的主机IP
								ta.append ( "Host: " + url.getHost ( ) );
								ta.append ( line );
								// 端口
								ta.append ( "Port: " + url.getDefaultPort ( ) );
								ta.append ( line );
								//网页属性
								ta.append ( "ContentType: "
										+ urlConn.getContentType ( ) );
								ta.append ( line );
								//网页数据长度
								ta.append ( "ContentLength: "
										+ urlConn.getContentLength ( ) );
								//构造一个输入流
								InputStream is = urlConn.getInputStream ( );
								//构造一个输出流,写入数据到文件中
								FileOutputStream fos = new FileOutputStream (
										"1.html" );

								int data;
								//以字节来读取数据
								while ( ( data = is.read ( ) ) != -1 )
								{
									fos.write ( data );
								}
								is.close ( );
								fos.close ( );
							} catch ( Exception ex )
							{
								ex.printStackTrace ( );
							}

						}
					} );
		jf.addWindowListener ( new WindowAdapter ( )
			{
				public void windowClosing ( WindowEvent e )
				{
					System.exit ( 0 );
				}
			} );
		jf.setVisible ( true );
	}
}

























































































































































Java中使用MySQL从安装、配置到实际程序测试详解

这里假设你的Java开发环境已经搭建好了。

一、准备工作：

下载MySQL：mysql-5.0.27-win32.zip
下载MySQL的JDBC jar包：mysql-connector-java-5.0.3-bin.jar

二、安装和测试MySQL

	MySQL在Windows下的安装很简单，注意在选择配置的有一项是将MySQL的配置导入系统环境变量中，
为了后面的方便这个选项要选项。
	安装完后，下面测试下：
1. 运行MySQL Server
M:\Documents and Settings\apple>mysqld-nt --help
mysqld-nt  Ver 5.0.22-community-nt for Win32 on ia32 (MySQL Community Edition (G
PL))
Copyright (C) 2000 MySQL AB, by Monty and others
This software comes with ABSOLUTELY NO WARRANTY. This is free software,
and you are welcome to modify and redistribute it under the GPL license

Starts the MySQL database server

Usage: mysqld-nt [OPTIONS]

For more help options (several pages), use mysqld --verbose --help

	这里可以看到mysqld-nt.exe是MySQL database server
我们再运行客户端进行连接:

如果这里说系统没有这个mysqld-nt命令，那么很可能是MySQL的配置信息没有导入系统环境变量中。这个时候可以将MySQL的安装目录下bin目录导入到系统PATH环境变量中，例如：
M:\WINDOWS\system32;M:\WINDOWS;M:\WINDOWS\System32\Wbem;M:\Program Files\MySQL\MySQL Server 5.0\bin
再运行 mysqld-nt 应该就没有问题了。

M:\Documents and Settings\apple>mysqld-nt

2.连接MYSQL。
格式： mysql -h主机地址 -u用户名 －p用户密码
例1：连接到本机上的MYSQL。
   首先在打开DOS窗口，然后进入目录 mysqlbin，再键入命令mysql -uroot -p，回车后提示你输密码，如果刚安装好MYSQL，超级用户root是没有密码的，故直接回车即可进入到MYSQL中了，MYSQL的提示符是：mysql>

   	M:\Documents and Settings\apple>mysql -uroot -p
	Enter password:
	Welcome to the MySQL monitor.  Commands end with ; or \g.
	Your MySQL connection id is 1 to server version: 5.0.22-community-nt

	Type 'help;' or '\h' for help. Type '\c' to clear the buffer.

	mysql>

例2：连接到远程主机上的MYSQL。假设远程主机的IP为：110.110.110.110，用户名为root,密码为abcd123。则键入以下命令：
  mysql -h110.110.110.110 -uroot -pabcd123
  （注:u与root可以不用加空格，其它也一样）

3、退出MYSQL命令： exit （回车）
mysql> exit
Bye

M:\Documents and Settings\apple>

三、在Java中使用MySQL数据库
1. 准数据库文件
创建一个LearnJava数据库:
M:\Documents and Settings\apple>mysql -uroot -p
Enter password: ******
Welcome to the MySQL monitor.  Commands end with ; or \g.
Your MySQL connection id is 6 to server version: 5.0.22-community-nt

Type 'help;' or '\h' for help. Type '\c' to clear the buffer.

mysql> create database LearnJava;
Query OK, 1 row affected (0.02 sec)

创建UserInfo表格:
mysql> use LearnJava;
Database changed
mysql> create table UserInfo(
    -> UserName varchar (20) not null,
    -> UserPwd varchar (20) not null
    -> );
Query OK, 0 rows affected (0.06 sec)

mysql>
插入一条数据:
mysql> insert into UserInfo values ('zieckey','123456');
Query OK, 1 row affected (0.03 sec)

mysql>

2. 将MySQL的JDBC jar包导入系统环境中
这里我是将mysql-connector-java-5.0.3-bin.jar放在java的安装目录下，
然后导入到CLASSPATH环境变量中，例如：
.;%JAVA_HOME%\lib\tools.jar;%JAVA_HOME%\lib\mysql-connector-java-5.0.3-bin.jar;%JAVA_HOME%\lib\dt.jar;



3. 新建 Java 程序 QueryJDBC.java
/**
 *	该程序用来测试JDBC和MySQL连接
 */
package test;

import java.sql.*;

public class QueryJDBC
{
	static
	{
		try
		{
			//驱动和odbc不同
			Class.forName ( "org.gjt.mm.mysql.Driver" );
			System.out.println ( "success loading mysql Driver...." );
		} catch ( Exception e )
		{
			System.out.println ( "Error loading mysql Driver....." );
			e.printStackTrace ( );
		}
	}

	/**
	 * @param args
	 */
	public static void main ( String agrs[] )
	{
		try
		{
			//连接参数与Access不同，这里LearnJava是上面建立的数据库名
			String url = "jdbc:mysql://localhost/LearnJava";
			//建立连接，root为登录数据库的用户名，123456为密码
			Connection con = DriverManager.getConnection ( url, "root", "123456'" );
			//建立发送SQL命令的Statement对象
			Statement stmt = con.createStatement ( );
			//返回查询结果
			ResultSet rs = stmt.executeQuery ( "select * from userinfo" );

			ResultSetMetaData md = rs.getMetaData ( );

			int col = md.getColumnCount ( );
			for ( int i = 1; i <= col; i++ )
			{
				System.out.println ( md.getColumnName ( i ) + "\t" );
			}
			while ( rs.next ( ) )
			{
				String strData = "";
				for ( int i = 1; i <= col; i++ )
				{
					strData = strData + rs.getString ( i ) + "\t";
				}
				System.out.println ( strData );
			}
			//断开Connection连接
			rs.close();
			stmt.close();
			con.close ( );
		} catch ( SQLException e )
		{
			e.printStackTrace ( );
		}
	}
}

E:\JavaLesson\MySQLTest\test>javac QueryJDBC.java -d .

E:\JavaLesson\MySQLTest\test>java test.QueryJDBC
success loading mysql Driver....
UserName
UserPwd
zieckey 123456

这里要特别提醒一下，如果在Eclipse下建立工程的，
该程序很可能运行出现异常，提示找不到org.gjt.mm.mysql.Driver，
这个可以通过 Project->Properties->Java Build Path->Libraries 选择 Add Extenal JARs，
然后就可以选择第三方jar包：mysql-connector-java-5.0.3-bin.jar
这样程序就可以正常运行了。

如果在Netbeans下开发的话，也要添加JAR包到IDE环境才行：
To use the Library Manager:
From the main menu, choose Tools > Library Manager.
In the Library Manager dialog box, click New Library.
In the New Library dialog box, name your library. Click OK.
Click Add JAR/Folder and browse to add the JAR file(s) needed for your classpath, source, or Javadoc.
In order for code completion to work properly in the IDE, you must either attach a complete set of source files as a folder or add the available source files as a Zip archive.

2007/1/18
关于实现序列化的类提示没有定义serialVersionUID域 分类:默认栏目
關於Eclipse的提示 The serializable class XXXXXX does not declare a static final serialVersionUID field of type long

采用自动修复，Eclipse会自动加上：private static final long serialVersionUID = 1L;
　　其实这个问题倒也不影响程序的运行，但是我看到Problems里面有警告就不舒服，同时也说明我们写的代码还是不规范。不怕，我们有互联网查查是怎么回事，具体的原因还就是和序列化中的这个serialVersionUID有关。
　　serialVersionUID 用来表明类的不同版本间的兼容性.如果你修改了此类, 要修改此值. 否则以前用老版本的类序列化的类恢复时会出错.
　　可以利用JDK的bin目录下的serialver.exe工具产生这个serialVersionUID
　　对于Test.class,执行命令： serialver Test
　　为了在反序列化时，确保类版本的兼容性，最好在每个要序列化的类中加入private static final long serialVersionUID这个属性，具体数值自己定义。这样，即使某个类在与之对应的对象已经序列化出去后做了修改，该对象依然可以被正确反序列化。否则，如果不显示定义该属性，这个属性值将由JVM根据类的相关信息计算，而修改后的类的计算结果与修改前的类的计算结果往往不同，从而造成对象的反序列化因为类版本不兼容而失败。
　　不显示定义这个属性值的另一个坏处是，不利于程序在不同的JVM之间的移植。因为不同的编译器实现的该属性值的计算策略可能不同，从而造成虽然类没有改变，但是因为JVM不同，依然会有因类版本不兼容而无法正确反序列化的现象出现。
　　因为我做的系统不太会经常需要序列化类，所以为了去掉这些警告，做如下设置：
Window－Preferences－Java，如图所示，将serializable class without serialVersionUID的设置由warning改为Ignore。然后Eclipse会重新编译程序，那些警告信息也就会消失了。
　　小结：如果我们开发大量需要序列化的类的时候，我们最好还是还原为原来的设置。这样可以保证系统的性能和健壮



我用eclipse写带图片的程序,工程里面不是自己带有一个res的文件夹么,但是我把图片放在里面就读取不到,要放在\verified\classes,里面,难道一定要跟class文件放在一起么??!!


Netbeans使用小技巧

netbean 安装完成后代码编辑窗口的默认字体看着不是很舒服，可以通过Tools->options->Editing->Editor Setting->Java(jsp,xml...) Editor->Fonts and Colors修改，字体修改为Dialog Input,Size=11就好看多了
netbean代码编辑器支持缩写，如输入sout会自动转换成System.out.println("")，预定义的快捷键和缩写代码可以在Help->Keyboard Shortcuts Card查看，也可以通过Tools->options->Editing->Editor Setting->Java(jsp,xml...) Editor->Abbreviations增加或修改
netbean里java代码自动完成提示过程中输入字符默认是大小写敏感的，用惯Jbuilder的可能很不舒服，可以通过Tools->options->Editing->Editor Setting->Java Editor->Expert->Case Sensitive Code Completion修改，把勾选去掉就可以不区分大小写了
netbeans会根据JSP头部的page指定自动识别JSP编码，所以如果JSP希望使用UTF-8编码只需在JSP文件一开始加上<%@ page contentType="text/html;charset=UTF-8"%>或<%@page pageEncoding="UTF-8"%>（JSP1.2）即可
java文件编码默认使用系统编码，可以通过java文件properties里的Text->Encoding单个修改，也可以通过Tools->options->Editing->Java Sources->Expert->Default Encoding统一修改
More...

netbean代码自动完成的快捷键默认的是：Ctrl+\



JNI关键词:
access native methods

在J2ME程序中，永远都无法直接调用本地库函数，因为Java的本地调用通常有两种方式：  
   
  一是JNI，但J2ME明确地不支持JNI；  
   
 二是KNI，但使用KNI的话，你的本地函数不是放在动态链接库里，而是要编到虚拟机的内部，我想一般情况下是没机会修改虚拟机的吧，更何况，你所用的虚拟机还有可能并不支持KNI，KNI最初只是KVM专用的，后来有一些虚拟机也用，但不是全部。  
   
  如果你对KNI感兴趣的话，欢迎参观一下我的blog，也许有一点帮助：  
  http://blog.csdn.net/fyzhao/archive/2006/08/28/1134113.aspx
  
  
J2ME/CDC applications can access native methods through the JNI (Java Native Interface) framework. The CLDC does not support JNI. For security reasons, CLDC applications are not allowed to access native methods. For CLDC, device vendors must build any native features into the runtime [3].  














http://community.polarion.com/projects/subversive/download/eclipse/2.0/builds/

http://www.pin5i.com/showtopic-23178.html

折腾了好久，终于搞定subversive和svn connector的安装了，过程很痛苦，因为eclipse的在线安装实在是太慢了......
    
    最后我的总结就是不要直接从网上安装，太慢太慢，会吐血而亡的，我已经深刻领略了......
    
    正确的方法是先从官方网站上下载安装包，然后再用eclipse的software update工具安装，这样速度就很快。我的1m的adsl，如果直接网上安装，大概1k下载速度，直接http下载安装包，大概在50-100k之间，差别够大吧？
    
    具体步骤如下：

1. 下载subversive

    
    进入这个网址 http://www.eclipse.org/subversive/downloads.php， 找到Latest Release - Recommended 在 Subversive plug-in - [required]下找到
    
        Archived Update Site: Subversive-incubation-0.7.7.I20090224-1900.zip
    
    （请无视叛变的在线更新地址 Update Site: http://download.eclipse.org/tech ... ve/0.7/update-site/）
    
    点链接将这个Subversive-incubation-0.7.7.I20090224-1900.zip文件下载下来，具体的地址是：
    
    http://www.eclipse.org/downloads ... .I20090224-1900.zip
    
    大小大概是17M。
    
2. 下载svn connector

    在刚才上面的链接下方，有svn connector的说明，给出下载地址
    
    http://www.polarion.com/products ... ?src=eclipseproject
    
    在这里找到Subversive Connector Archives，有链接指向安装包，将它下载下来，具体地址是：
    
    http://www.polarion.org/projects ... .I20090213-1500.zip
    
    这个包18M。
    
    上面两个包加起来35m，我不知道1k的速度要下载多久......
    
3. 安装subversive

    eclispe -> software updates -> available software -> Manage Sites
    首先取消所有site，否则eclipse还是要去更新一些东西，在我这里下载的速度大概是100字节每秒，详细请看我的上一个帖子。
    然后add -> archive，指向刚才下载的Subversive-incubation-0.7.7.I20090224-1900.zip文件，小心add之后software updates工具会自动勾选几个eclipse的站点，千万记住再次取消他们，只保留subversive一个。之后就一路顺利安装，完成后会要求重启。
    
4. 安装svn connector

    和上面的方式一致。
    注意在选择安装内容时，全选，我开始只选了一个svn connector，结果不能用, subversive的设置中无法选择connector。后来第二次安装时全选就能用了。
    
5. 设置svn connector
    eclipse -> windows -> preferences -> team -> svn
    点SVN Connector，然后选择一个要用的connector，我选择的是SVN Kit(SVN/1.5.5 r5428)，apply.
    
    这样就完成了整个的安装，我测试过可以正常连接subversion服务器。














Java NIO(New IO) 还是在 JDK 1.4 中引入的新特性。JDK 1.4 的另一重要特性正则表达式大家应该经常用到，但 NIO 就可能使用寥寥了，大概是缘于旧有 IO 体系仍然够用。有如 JDK1.5 早就泛型和注解了，但基于各种原因而无法亲力去实践泛型和注解一般，NIO 多数时候也只是与我们擦着肩而已。（文/隔叶黄莺）

相比与 Old IO，NIO 在某些领域里确有其过人之处，所以现在让我们一起来对 NIO 有个更楚的认识。

NIO 的相关 API，在 java.nio 中，它会与你纠缠的就是各种 Channel 和 Buffer。相关的应用在于处理通道和缓冲区、异步(非阻塞)的 IO、文件的锁定、字符集的处理上。

Channel 可以通过调用 FileInputStream、FileOutputStream、RandomAccessFile、DatagramSocket、 ServerSocket 和 Socket 的 getChannel() 方法获得。Channel 有点像旧 I/O 的流，旧 I/O 的读写操作可以在流上直接进行，而 NIO 都是在各种 Buffer 上读写数据。

由于使用了独有的通道和缓冲区，相比旧有的 IO 流处理的是字节流(流 IO)，NIO 所使用的方式是块 I/O，所以在大块数据处理时块 I/O 比流 I/O 效率要高。NIO 在一定程度上相当于用本地代码来处理了 I/O 操作。

异步 I/O 使得你在进行网络传输时，无需像原来那样 read()/write() 来阻塞线程来等待数据的到来和直至写完数据。NIO 的方式是注册监听器来监听通道上的事件，在一个线程上就能流畅的处理 Socket 通信。不像旧 I/O 必须求助于轮询并创建许许多多的线程来处理大量的连接。

例如，基于 NIO 的组件有，网络应用框架 Apache MINA，Memcached 客户端 XMemcached，Socket 应用组件 xSocket，还有 Tomcat 6 也支持使用 NIO 的 connector 了。

文件锁使得 Java 程序也可以对整个文件或文件的部分进行独占(排它)或共享的读或写，防止了不同的进程对同一个文件的干扰。不过在不同的作系统下的行为可能会有细微的差异。文件锁(Lock)可以通过 Channel 的 lock() 或 tryLock() 获得，Channel 的 release() 方法或关闭通道时即释放了锁。

另外，NIO 可以更好的使用控制字符集。

与 NIO 还有一个很重要的 Buffer 就是内存映射文件--通过调用 FileChannel 类的 map() 方法可获得 MappedByteBuffer，此内存映射文件与 Windows 下的内存映射有相似性，又不尽然，Windows 下的内存映射文件可用来在不同的进程间共享数据，Java 的这个东西要细究下。

以上本就是泛泛而语，初识者或会觉得不知所云，也无甚味可解，原本就是对 Java NIO 的粗犷的理解，杂乱而无序。

在 IBM DeveloperWorks 上有一个 Java NIO 入门教程，https://www6.software.ibm.com/developerworks/cn/education/java/j-nio/tutorial/index.html，为了便于学习和分享，特制作成了一个 chm 文件，在文末有下载。

参考资料：
1. 基于事件的NIO多线程服务器
2. Servlet API 和 NIO: 最终组合在一起
3. Java NIO原理和使用
4. 使用Java NIO编写高性能的服务器
5. Java NIO API详解
6. nio文件读写






对于 NIO 来说，Channel(通道) 和 Buffer(缓冲区) 这两个东西是不得不提的，因为它们是 NIO 的核心对象，几乎每一个 I/O 操作都要它们。

通道是对原 I/O 流的模拟，但有不同的是它是双向的，不再像流那样分 InputStream 和 OutputStream，通道的双向性更好的反映了底层操作系统的真识情况。也不能像原 I/O 那样可以直接往流里写或读数据，在通道了传输数据必须经由缓冲区。有点类似原 I/O 流通过过滤器流 BufferedInputStream 和 BufferedOutputStream 来读写数据。

FileInputStream/FileOutputStream/RandomAccessFile/DatagramSocket/ServerSocket/Socket 的 getChannel() 方法可以获得相应类型的 Channel，Channel 的类型有 FileChannel/SocketChannel/SelectableChannel/DatagramChannel/ServerSocketChannel 等。

在通道上的读写都会关联上缓冲区，如 FileChannel.read(ByteBuffer dst)、FileChannel.write(ByteBuffer src)；对文件的锁也是在通道上的操作，如 FileChannel.lock()、FileChannel.tryLock()。

Buffer 接口的实现类有 ByteBuffer/MappedByteBuffer/CharBuffer/DoubleBuffer/FloadBuffer /IntBuffer/LongBuffer/ShortBuffer，用得多的还就是 ByteBuffer。在 Buffer 上则是些存取数据和数据定位的操作。

下面是 NIO 和原 IO 的一些概念对比：

附件: nio-oio.jpg 

其他的如 SocketChannel 网络通道还未述及，理解了 NIO 通道和缓冲区的概念之后，我们就可以使用 NIO 来对文件进行读写操作了。（文/隔叶黄莺）














我们用原有 IO 读写文件应该不会陌生了，顺带回顾一下，大致两种：

1. 在 InputStream 或 OutputStream 上读写字节或字节数组，读 InputStream 时用是否返回 -1 来判断是否到达末尾。
2. 包装成 Reader/Writer 可以直接读写字符串，进一步包装到 BufferedReader/BufferedWriter 就可以按行读写了。readLine() 时看是否返回 null 断定是否读完了最后一行。

现在我们要用 NIO 来读写文件，肯定是要用到 Channel 和 Buffer 了。一句话描述过程就是从 FileInputStream 得到的 FileChannel 中读取数据到 Buffer 中，再处理 Buffer 中的数据。看代码：
01.public static void main(String[] args) throws Exception {
02.    FileInputStream fis = new FileInputStream("C:/Java/jdk1.6.0_18/LICENSE");
03.    
04.    //得到文件通道
05.    FileChannel fc = fis.getChannel();
06.    
07.    //分配与文件尺寸等大的缓冲区
08.    ByteBuffer bf = ByteBuffer.allocate((int) fc.size());
09.    
10.    //整个文件内容全读入缓冲区，即是内存映射文件
11.    fc.read(bf);
12.    
13.    //把缓冲中当前位置回复为零
14.    bf.rewind();
15.    
16.    //输出缓冲区中的内容
17.    while (bf.hasRemaining()) {
18.        System.out.print((char) bf.get());
19.    }
20.}
复制代码
上面程序使用了一个与文件尺寸等大的缓冲区，正好能一次性把文件内容全部读入内存，如果文件过多将是十分耗费的内存的，所以我们可能须手工指定某个大小(如 1024,2048) 的缓冲区，然后分多次读入文件内容到缓冲区中。这时候程序就是下面那样子了：
01.public static void main(String[] args) throws Exception {
02.    FileInputStream fis = new FileInputStream("C:/Java/jdk1.6.0_18/LICENSE");
03. 
04.    // 得到文件通道
05.    FileChannel fc = fis.getChannel();
06. 
07.    // 指定大小为 1024 的缓冲区
08.    ByteBuffer bf = ByteBuffer.allocate(1024);
09. 
10.    // 读取通道中的下一块数据到缓冲区中
11.    // 缓冲区的 position 即为当前缓冲区中最后有效位置
12.    while (fc.read(bf) != -1) {
13. 
14.        //把缓冲中当前位置回复为零，前把缓冲区的 limit 设置为之前 position 值
15.        bf.flip();
16. 
17.        // 输出缓冲区中的内容
18.        while (bf.hasRemaining()) {
19.            System.out.print((char) bf.get());
20.        }
21. 
22.        // 清理缓冲区，准备再次读取数据
23.        bf.clear();
24.    }
25.}

留意对缓冲区的 rewind()/flip()/clear() 操作所产生的影响，即对 position/limit/mark 等标志的影响。最后提醒操作完之后，要关闭通道和输入流。

用 ByteBuffer 知道了怎么读文件内容(当然，还未涉及到中文内容)并打印到屏幕后，再来看看 NIO 怎么写文件：

view source
print?
01.public static void main(String[] args) throws FileNotFoundException, IOException{
02.    FileOutputStream fos = new FileOutputStream("c:/nio.tst");
03. 
04.    // 得到文件通道
05.    FileChannel fc = fos.getChannel();
06. 
07.    // 指定大小为 1024 的缓冲区
08.    ByteBuffer bf = ByteBuffer.allocate(1024);
09. 
10.    // 要写入文件的字符串
11.    String greeting = "Hello, Java NIO";
12.    
13.    //把以上字符串逐字放入缓冲区
14.    for (int i = 0; i < greeting.length(); i++) {
15.        bf.putChar(greeting.charAt(i));
16.    }
17.    
18.    // 记得执行这个方法，使得 position=0, limit=30, 才能写入正确的数据
19.    // 否则 position 为 30, limit 为 1024，将会把 30 之后的全部空数据(0) 填到文件中
20.    bf.flip();
21. 
22.    // 缓冲区数据写入到文件中，会把缓冲区中从 position 到 limit 之间的数据写入文件
23.    fc.write(bf);
24.    
25.    fc.close(); //关闭文件通道
26.    fos.close(); //关闭文件输出流
27.}
复制代码
同样的，如果是写入中文内容，也需要进行字符集的相关处理。执行后在 C 盘根目录下产生 nio.tst 文件，内容就是 Hello, Java NIO。此代码的关键之处就是对缓冲的 flip() 调用，你可以在调试模式下观察到 flip() 方法调用前后，缓冲区 bf 的 position/limit 属性的变化。试着注释掉 flip() 代码，看看两次生成的 nio.tst 文件内容是不是大相径庭。

所以，要用好 NIO，缓冲区的 mark/position/limit/capacity 属性应理解，以及 clear()/flip()/rewind() 分别会怎么影响到以上属性。

还有，虽然说通道是双向的，字面上不像流那样区分输入通道或是输出通道，但实际通道也存在只读或只写的特性，例如由 FileInputStream.getChannel() 获得的通道是无法写入内容的，由 FileOutputStream.getChannel() 获得的通道是不能读的，否则会抛出相应的异常 NonWritableChannelException 和 NonReadableChannelException。而且 Buffer 也存在着是否只读的属性。

前面的代码在这里只是说明用 NIO 读写文件应如何处理，并不是说比起用旧 IO 流式的写法效率就更高了。NIO 的高效率只会体现在有些时候，并非任何时候都优于旧 IO，那是块操作和字节操作的区别，用 NIO 时要小心内存。伸手就能摘到的梨用不着搬个凳子，何况旧 IO 实现起来还更简洁些呢! （文/隔叶黄莺）

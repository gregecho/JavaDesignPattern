## 创建型模式 ##
> #### 工厂方法模式-Factory Method Pattern ####
>+ 简单工厂模式-Simple Factory Pattern
>+ 工厂方法模式- Factory Method Pattern
>+ 抽象工厂模式- Abstract Factory Pattern

-----
## 正文 ##
### 1. 工厂模式 ###
#### 1.1 简单工厂模式-Simple Factory Pattern ####
> 定义：定义一个**工厂类**，它可以根据参数的不同返回不同类的实例，被创建的实例通常都具有共同的父类。因为在简单工厂模式中用于创建实例的方法是静态(static)方法，因此简单工厂模式又被称为静态工厂方法(Static Factory Method)模式，它属于类创建型模式。

简单工厂模式结构图：
![简单工厂模式结构图](images/SimpleFactory.jpg)

简单工厂模式主要包含以下几个角色：
>+ Factortory(工厂角色)：工厂角色即工厂类，它是简单工厂模式的核心，负责实现创建所有产品实例的内部逻辑；工厂类可以被外界直接调用，创建所需的产品对象；在工厂类中提供了静态的工厂方法factoryMethod()，它的返回类型为抽象产品类型Product。
>+ Product（抽象产品角色）：它是工厂类所创建的所有对象的父类，封装了各种产品对象的公有方法，它的引入将提高系统的灵活性，使得在工厂类中只需定义一个通用的工厂方法，因为所有创建的具体产品对象都是其子类对象。
>+ ConcreteProduct（具体产品角色）：它是简单工厂模式的创建目标，所有被创建的对象都充当这个角色的某个具体类的实例。每一个具体产品角色都继承了抽象产品角色，需要实现在抽象产品中声明的抽象方法。

简单工厂模式的主要优点：
>+ 工厂类包含必要的判断逻辑，可以决定在什么时候创建哪一个产品类的实例，客户端可以免除直接创建产品对象的职责，而仅仅“消费”产品，**简单工厂模式实现了对象创建和使用的分离**。
>+ 通过**引入配置文件**，可以在不修改任何客户端代码的情况下更换和增加新的具体产品类，在一定程度上提高了系统的灵活性并且**遵守了开放封闭原则**。

简单工厂模式的主要缺点：
>+ 由于工厂类集中了所有产品的创建逻辑，职责过重，一旦不能正常工作，整个系统都要受到影响。
>+ 使用简单工厂模式势必会增加系统中类的个数（引入了新的工厂类），增加了系统的复杂度和理解难度。
>+ 系统扩展困难，一旦添加新产品就不得不修改工厂逻辑，在产品类型较多时，有可能造成工厂逻辑过于复杂，不利于系统的扩展和维护，并且**违背了开放封闭原则**。
>+ 简单工厂模式由于使用了静态工厂方法，造成工厂角色无法形成基于继承的等级结构。

简单工厂模式适用场景：
>+ 工厂类负责创建的对象比较少，由于创建的对象较少，不会造成工厂方法中的业务逻辑太过复杂。例如，数据库连接字符串的管理。
>+  客户端只知道传入工厂类的参数，对于如何创建对象并不关心。

简单工厂模式中工厂类示例代码：
```java
public class ChartFacotry {
	public static Chart getChart(String type){
		Chart chart = null;
		if(type.equalsIgnoreCase("pie")){
			chart = new PieChart();
		}else if(type.equalsIgnoreCase("line")){
			chart = new LineChart();
		}
		return chart;
	}
}
```

示例代码：
> [SimpleFactoryPattern源代码][1]    

[1]: https://github.com/gregecho/JavaDesignPattern/tree/master/SimpleFactoryPattern/src/main

**总结：**
> 简单工厂模式虽然简单，但存在一个很严重的问题。当系统中需要引入新产品时，由于静态工厂方法通过所传入参数的不同来创建不同的产品，这必定要修改工厂类的源代码，将违背“开闭原则”，如何实现增加新产品而不影响已有代码？工厂方法模式应运而生，下节将介绍第二种工厂模式——工厂方法模式。

-----

#### 1.2 工厂方法模式- Factory Method Pattern ####
在工厂方法模式中，我们**不再提供一个统一的工厂类来创建所有的产品对象，而是针对不同的产品提供不同的工厂，系统提供一个与产品等级结构对应的工厂等级结构**。工厂方法模式定义如下：
> **定义**：工厂方法模式(Factory Method Pattern)：定义一个用于创建对象的接口，让子类决定将哪一个
类实例化。工厂方法模式让一个类的实例化延迟到其子类。工厂方法模式又简称为工厂模式(Factory Pattern)，又可称作虚拟构造器模式(Virtual Constructor Pattern)或多态工厂模式(Polymorphic Factory Pattern)。工厂方法模式是一种类创建型模式。

工厂方法模式结构图：
![工厂方法模式结构图](images/FactoryMethod.jpg)

工厂方法模式主要包含以下几个角色：
>+ Product（抽象产品）：它是定义产品的接口，是工厂方法模式所创建对象的超类型，也就是产品对象的公共父类。
>+ ConcreteProduct（具体产品）：它实现了抽象产品接口，某种类型的具体产品由专门的具体工厂创建，具体工厂和具体产品之间一一对应。
>+ Factory（抽象工厂）：在抽象工厂类中，声明了工厂方法(Factory Method)，用于返回一个产品。抽象工厂是工厂方法模式的核心，所有创建对象的工厂类都必须实现该接口。
>+ ConcreteFactory（具体工厂）：它是抽象工厂类的子类，实现了抽象工厂中定义的工厂方法，并可由客户端调用，返回一个具体产品类的实例。

**与简单工厂模式相比，工厂方法模式最重要的区别是引入了抽象工厂角色，抽象工厂可以是接口，也可以是抽象类或者具体类**

工厂方法模式的主要优点：
>+  在工厂方法模式中，工厂方法用来创建客户所需要的产品，同时还向客户隐藏了哪种具体产品类将被实例化这一细节，用户只需要关心所需产品对应的工厂，无须关心创建细节，甚至无须知道具体产品类的类名。
>+ 基于工厂角色和产品角色的多态性设计是工厂方法模式的关键。它能够让工厂可以自主确定创建何种产品对象，而如何创建这个对象的细节则完全封装在具体工厂内部。工厂方法模式之所以又被称为多态工厂模式，就正是因为所有的具体工厂类都具有同一抽象父类。
>+ 使用工厂方法模式的另一个优点是在系统中加入新产品时，无须修改抽象工厂和抽象产品提供的接口，无须修改客户端，也无须修改其他的具体工厂和具体产品，而**只要添加一个具体工厂和具体产品就可以了**，这样，系统的可扩展性也就变得非常好，完全符合**“开闭原则”**。

工厂方法模式的主要缺点：
>+ 在添加新产品时，**需要编写新的具体产品类，而且还要提供与之对应的具体工厂类**，系统中类的个数将成对增加，在一定程度上增加了系统的复杂度。
>+ 由于考虑到系统的可扩展性，需要引入抽象层，在客户端代码中均使用抽象层进行定义，增加了系统的抽象性和理解难度，且在实现时可能需要用到DOM、反射等技术，增加了系统的实现难度。

工厂方法模式适用场景：
>+ 客户端不知道它所需要的对象的类。在工厂方法模式中，客户端不需要知道具体产品类的类名，只需要知道所对应的工厂即可，具体的产品对象由具体工厂类创建，可将具体工厂类的类名存储在配置文件或数据库中。
>+  抽象工厂类通过其子类来指定创建哪个对象。在工厂方法模式中，对于抽象工厂类只需要提供一个创建产品的接口，而由其子类来确定具体要创建的对象，**利用面向对象的多态性和里氏代换原则**，在程序运行时，子类对象将覆盖父类对象，从而使得系统更容易扩展。

示例代码结构图：
![示例代码结构图](images/FactoryMethodLogger.jpg)

示例代码：
> [FactoryMethodPattern源代码][1]    

[1]: https://github.com/gregecho/JavaDesignPattern/tree/master/FactoryMethodPattern/src/main

-----
#### 1.3 抽象工厂模式- Abstract Factory Pattern ####
抽象工厂模式为创建一组对象提供了一种解决方案。与工厂方法模式相比，**抽象工厂模式中的具体工厂不只是创建一种产品，它负责创建一族产品**。抽象工厂模式定义如下：
> 抽象工厂模式(Abstract Factory Pattern)：提供一个创建一系列相关或相互依赖对象的接口，而无须指定它们具体的类。抽象工厂模式又称为Kit模式，它是一种对象创建型模式。

**在抽象工厂模式中，每一个具体工厂都提供了多个工厂方法用于产生多种不同类型的产品，这些产品构成了一个产品族**，抽象工厂模式结构如图所示：
![抽象工厂模式结构](images/abstractfactorypattern.jpg)

抽象工厂模式主要包含以下几个角色：
>+ AbstractFactory（抽象工厂）：它声明了一组用于创建一族产品的方法，每一个方法对应一种产品。
>+ ConcreteFactory（具体工厂）：它实现了在抽象工厂中声明的创建产品的方法，生成一组具体产品，这些产品构成了一个产品族，每一个产品都位于某个产品等级结构中。
>+ AbstractProduct（抽象产品）：它为每种产品声明接口，在抽象产品中声明了产品所具有的业务方法。
>+ ConcreteProduct（具体产品）：它定义具体工厂生产的具体产品对象，实现抽象产品接口中声明的业务方法。

抽象工厂模式的主要优点：
>+   抽象工厂模式隔离了具体类的生成，使得客户并不需要知道什么被创建。由于这种隔离，更换一个具体工厂就变得相对容易，所有的具体工厂都实现了抽象工厂中定义的那些公共接口，因此只需改变具体工厂的实例，就可以在某种程度上改变整个软件系统的行为。
>+ 当一个产品族中的多个对象被设计成一起工作时，它能够保证客户端始终只使用同一个产品族中的对象。
>+ 增加新的产品族很方便，无须修改已有系统，符合“开闭原则”。

抽象工厂模式的主要缺点：
>+ 增加新的产品等级结构麻烦，需要对原有系统进行较大的修改，甚至需要修改抽象层代码，这显然会带来较大的不便，违背了“开闭原则”。

抽象工厂模式适用场景：
>+ 一个系统不应当依赖于产品类实例如何被创建、组合和表达的细节，这对于所有类型的工厂模式都是很重要的，用户无须关心对象的创建过程，将对象的创建和使用解耦。
>+  系统中有多于一个的产品族，而每次只使用其中某一产品族。可以通过配置文件等方式来使得用户可以动态改变产品族，也可以很方便地增加新的产品族。
>+  产品等级结构稳定，设计完成之后，不会向系统中增加新的产品等级结构或者删除已有的产品等级结构。

**如果需要增加新的产品该怎么办？**如果需要增加单选按钮，首先需要修改抽象工厂接口SkinFactory，在其中新增声明创建单选按钮的方法，然后逐个修改具体工厂类，增加相应方法以实现在不同的皮肤中创建单选按钮，此外还需要修改客户端，否则单选按钮无法应用于现有系统。
> 答案是抽象工厂模式无法解决该问题，这也是抽象工厂模式最大的缺点。**在抽象工厂模式中，增加新的产品族很方便，但是增加新的产品等级结构很麻烦**，**抽象工厂模式的这种性质称为“开闭原则”的倾斜性**。“开闭原则”要求系统对扩展开放，对修改封闭，通过扩展达到增强其功能的目的。

示例代码结构图：
![示例代码结构图](images/abstractfactoryskin.jpg)

示例代码：
> [AbstractFactoryPattern源代码][1]    

[1]: https://github.com/gregecho/JavaDesignPattern/tree/master/AbstractFactoryPattern/src/main

-----
### TODO

* [ ] 工厂模式在spring中的运用
* [x] test



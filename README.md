"# algotithm" 

一、基本的算法

 (1)排序算法
    
    1.插入排序

    2.选择排序

    3.归并排序
     
        归并排序算法并不是原地排序算法，时间复杂度是O(nlogn)，空间复杂度是O(n)
        leetcoe递归算法的应用：category.leetcode.swort.leetcode51.ReversePair
    
    4.快速排序
    
        .普通快速排序
        .双路快速排序
        .三路快速排序
     
     5.冒泡排序法
     6.希尔排序法
     7.堆排序法
 (2)查找算法
    
    1.线性查找法
    
    2.二分查找法
   
        对于有序数列，才能使用二分查找法
            .使用递归的方式实现二分查找
            .使用循环的方式实现二分查找       

二、数据结构

    1.线性结构
        数组；栈；队列；链表；哈希表。。。
        链表：
            优点：真正的动态， 不需要处理固定容量的问题
            缺点：丧失了随机访问的能力
    
    2.树结构
        二叉树；二分搜索树；AVL；红黑树；Treap；Splay；堆；Trie；线段树；
        K-D树；并查集；哈夫曼树；。。。
        
        二分搜索树：
            深度优先遍历：
                前序遍历、中序遍历、后序遍历
            广度优先遍历：
            有一定问题，可能会退化成链表
            
        堆和优先队列：
            普通队列：先进先出、后进后出
            优先队列：出队顺序和入队顺序无关；和优先级顺序有关
            
            二叉堆：
                本质是一棵完全二叉树，元素按照层级关系填充，先填满当前层，才会继续填充下一层。
             堆中的节点值总是不大于其父节点的值。
                最大堆:根节点是最大的元素
                最小堆：根节点是最小的元素
    
        平衡二叉树：
            树的最大深度和最小深度差值为1
            
        线段树：
            
    3.图结构
        邻接矩阵；邻接表
三、例子

    1.数据库
        AVL；红黑树；B类树；哈希表
    2.操作系统
        优先队列
        内存管理：内存堆栈
        文件管理
    3.文件压缩
        各种压缩算法
            eg：哈夫曼树
    
四.提高自己的注意力

    1.明确自己要做什么，要集中精力去做什么事情,明确需要集中注意力做这件事是为什么了。
    2.记录自己的注意力开销，发现有哪些事情影响了自己。
    3.对症下药，切断影响自己注意力的事物
    4.要从自己的主观上提高自己的专注度
    
    
    
杂记：
    
        1.Java中引用类型
            在Java语言中，除了原始数据类型的变量外，其他所有都是所谓的引用类型，指向各种不同的对象。
         不同的引用类型，主要体现的是"对象不同的可达性状态和对垃圾收集的影响"。
            (1)强引用
                强引用，就是我们最常见的普通对象引用，只要还有强引用指向一个对象，就能表明对象还"活着"，垃圾收集器就不会去
             尝试回收该对象。对于一个普通的对象，如果没有其他的引用关系，只要超过了引用的作用域或者显示地将引用赋值为null，
             那么该对象就可以被当做垃圾收集了，当然，具体回收时期还是要看垃圾收集策略。
            (2)软引用
                软引用，是一种相对强引用，较弱的一种引用，可以让对象在一定条件下避免被当做垃圾清理掉。只有当JVM认为内存不足
             时，才会去试图回收软引用指向的对象。JVM会确保在抛出OutOfMemoryError之前，清理软引用指向的对象。软引用通常用来
             实现内存敏感的缓存，如果还有空闲内存，就可以暂时保留缓存，当内存不足时清理掉，这样可以保证了使用缓存的同时，又不会
             造成内存耗尽。
             (3)弱引用
                弱引用，并不能使JVM在垃圾回收时对其豁免，仅仅是提供一种访问在弱引用状态下对象的对象的途径。这就可以用来构建
             一种没有特定约束的关系，比如，维护一种非强制性的映射关系，如果试图获取对象时，对象还在就使用它，否则实现实例化。
             它同样是很多缓存实现的选择。
             (4)幻象引用(虚引用)
                对于幻象引用，有时候也被称为虚引用，我们不能通过它来访问对象。幻象引用仅仅是提供了一种确保对象被finalize后，
              做某些事情的机制。比如，通常被用来做所谓的Post-Mortem清理机制，也有人用幻象引用做监控对象的创建和销毁。
        2.Java对象可达性级别
            (1)强可达
                当一个对象可以有一个或多个线程可以不通过各种引用被访问到的情况。比如，我们新创建一个对象，那么创建他的线程
             对这个对象就是强可达。
             (2)软可达
                只能通过软引用才能访问到的对象的状态
             (3)弱可达
                对象无法通过强引用或者软引用访问，只能通过弱引用访问时的状态。这是十分临近finalize状态的时机，当弱引用被
              清除的时候，就符合finalize的条件了。
             (4)幻象可达
                没有强、软、弱引用关联，并且finalize过了，只有幻象引用指向这个对象的时候
        3.Java中String、StringBuffer、StringBuilder
            (1)String是Java语言非常基础和重要的类，其提供了构造和管理字符串的各种基本逻辑。它是典型的Immutable类，被声明为
         final class，其所有属性也是final的。也由于它的不可变性，类似拼接、裁剪字符串等操作，都会产生新的String对象。由于
         字符串操作的普遍性，所以相关操作的效率往往对应用性能有明显的影响。
            (2)StringBuffer是为解决上字符串拼接产生太多中间对象的问题而提供的一个类，我们可以用append或者add方法，把字符串
         添加到已有序列的末尾或者指定位置。StringBuffer本质是一个线程安全的可修改字符序列，它保证了线程安全，也随之带来了额外的
         性能开销，所以除非有线程安全的需要，大多数还是使用StringBuilder
            (3)StringBuilder,其在能力上和Stringbuffer没有什么区别，只是去掉了线程安全的能力，减少了开销。
        4.动态代理
            编程语言通常有各种不同的分类角度，动态类型和静态类型是其中的一种分类角度，简单区分就是语言类型信息是在运行时检查，还是
         编译期检查。与其类似的还有一个对比，就是所谓强类型和弱类型，就是不同类型变量赋值时，是否需要显示地(强制)进行类型转换。
            那么如何区分Java语言呢？通常我们认为，Java是静态的强类型语言，但是因为其提供了类似反射机制，它也具备了部分动态类型
         语言的能力。
            问：Java中的动态代理是基于什么原理？
                反射机制是Java语言提供了一种基础功能，赋予程序在运行时自省的能力。通过反射我们可以直接操作类或者对象，比如获取某个
             类的定义，获取类声明的属性和方法，调用方法或者构造对象，甚至可以运行时修改类定义。
                动态代理是一种方便运行时动态构建代理、动态处理代理方法调用的机制，很多场景都是利用类似机制做到的，比如包装RPC调用、
             面向切面编程(AOP).
                实现动态代理的方式有很多，比如JDK自身提供的动态代理，就是主要利用了上面提到的反射机制。还有其他的实现方式，比如利用
             传说中更高性能的字节码操作机制，类四ASM、cglib、javassist等。
        5.Java原始数据类型和包装类型
            问：int和Integer有什么区别？谈谈Integer的值缓存范围
                int是我们常说的整型数字，是java的8个原始数据类型之一(byte、char、short、int、float、double、long、boolean)。
             java虽然号称一切都是对象，但原始数据类型例外。
                Integer是int对应的包装类，它有一个int类型的字段存储数据，并且提供了基本操作，比如数学运算、int和字符串之间的转换等。
             在java5中，引入了自动装箱和自动拆箱功能，java可以根据上下文，自动进行转换，极大地简化了相关编程。
                关于Integer值的缓存，这涉及java5中的另一个改进。构建Integer对象的传统方式是直接调用构造器，直接new一个对象。但是根据
             实践，我们发现大部分数据操作都是集中在有限的、较小的数值范围，因而，在Java5中新增了静态工厂方法valueOf，在调用它的时候会
             利用一个缓存机制，带来了明显的性能改进。按照Javadoc，这个值默认缓存是在-128到127之间。

    
    


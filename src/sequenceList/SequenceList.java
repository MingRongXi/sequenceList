
/*

* @(#)SequenceList.java 1.0.0 09/19/2018
*
* Copyright 2018 ZhaoLei. All rights reserved.
*
* Use is subject to license terms.
 */

package sequenceList;

/*
*这个类创建了�?个顺序表，这个类的一个对象就是一个顺序表，该对象中可以储存任意类型的同种数据，并且能够动态得实现储存功能
* 可以通过下标找到对应元素，也可以通过元素找到该元素所在的位置
*
*  @author    ZhaoLei
*
*  @version   1.0.0, 09/18/2019
*
*  @see       java.lang.Class
*
*  @since     JDK1.8.0

 */

public class SequenceList<E> {
    /**
     * size是用来实时监控动态数组中元素个数�?
     */
    private int size;
    /**
     * defaultCapacity是创建一个SequenceList对象不指定数组长度时的默认长�?
     */
    private final int defaultCapacity = 10;
    /**
     * elements就是�?个可以储存任意类型的数组
     */
    private E[] elements;

    /**
     * 无参构�?�方法，创建�?个指定长度的数组
     */
    public SequenceList(){
        this.elements = (E[])new Object[defaultCapacity];
        size = 0;
    }

    /**
     * 有参数的构�?�方法，创建�?个指定长度的数组
     * @param capacity  用于指定创建数组的长�?
     */
    public SequenceList(int capacity){
        if(capacity<0){
            throw new ArrayIndexOutOfBoundsException();
        }
        this.elements = (E[])new Object[capacity];
        size = 0;
    }

    /**
     * 将元素添加到数组中的指定位置
     * @param index       想要添加到的位置
     * @param element     将要添加的元�?
     */
    public void add(int index, E element){
        //首先调用checkIndex方法判断要添加的位置是否有效，即大于等于零，小于等于size
        checkIndex(index);

        //当数组中已有的元素等于指定长度时，调用changeCapacity方法将数组长度变为原来的2�?
        if(elements.length == size){
            changeCapacity(2*size);
        }

        //将所有的数据�?后移�?位，为新数据让出空间
        for(int i = size; i > index; i--){
            elements[i] = elements[i - 1];
        }

        elements[index] = element;  //将数据插入到指定位置
        size++;  //新添加一个元素，size加一
    }


    /**
     * 添加元素到数组末�?
     * @param element 将要添加的元�?
     */
    public void add(E element){
        add(size, element); //添加元素到数组末尾，直接将index设置为size
    }

    /**
     * 删除指定位置的元�?
     * @param index 指定的位�?
     */
    public E remove(int index){
        //�?查位置是否有�?
        checkIndex(index);
        E deleted = elements[index];

        //将index后面的数据都依次向前挪一位，将该位置的原有的元素覆盖
        for(int i = index; i < size; i++){
            elements[i] = elements[i + 1];
        }
        size--;
        return deleted;
    }


    /**
     * 删除指定的元�?
     * @param element  将要删除的元�?
     */
    public void remove(E element){
        //先查到该元素�?在的位置
        int index = getIndex(element);

        //当要删除的元素存在时，调用删除指定位置元素的方法
        if(index != -1){
            remove(index);
        }

    }
    
    public E remove() {
    	E deleted = elements[size - 1];
    	size--;
    	return deleted;
    }


    /**
     * 修改指定位置的元�?
     * @param index          指定的位�?
     * @param newElement     修改之后的数�?
     */
    public void setElement(int index, E newElement){
        //�?查位置是否有�?
        checkIndex(index);
        elements[index] = newElement;
    }


    /**
     * 将某个指定元素换为新的元�?
     * @param oldElement  将要被修改的元素
     * @param newElement  用来替换的新元素
     */
    public void setElement(E oldElement, E newElement){
        int modifiedIndex = getIndex(oldElement);
        elements[modifiedIndex] = newElement;
    }

    /**
     * 查询指定元素的位�?
     * @param element     要查询的元素
     * @return             返回该元素所在的位置
     */
    public int getIndex(E element){
        for (int i = 0; i <= size; i++){
            if (element.equals(elements[i])){
                return i;
            }
        }

        throw new ArrayIndexOutOfBoundsException("没有此元�?");
    }

    /**
     * 得到指定位置的元�?
     * @param index    指定的位�?
     * @return          返回该位置的元素
     */
    public E getElement(int index){
        checkIndex(index);
        return elements[index];
    }

    public E getElement(){
        return elements[size - 1];
    }
    /**
     * 将数组的大小变为指定的长�?
     * @param newSize  指定的长�?
     */
    private void changeCapacity(int newSize){
        //必须在指定长度大于size的情况下才能改变，防止数据丢�?
        if(newSize > size){
            E[] oldElements = elements;
            elements = (E[]) new Object[newSize];
            for(int i = 0; i < size; i++){
                elements[i] = oldElements[i];
            }
        }
    }


    /**
     * 将数组的长度缩小至元素的个数，节约空�?
     */
    public void trimCapacity(){
        changeCapacity(size);
    }


    /**
     * �?查索引是否有效，即必须大于等�?0，小于等于size
     * @param index    要检查的索引
     */
    private void checkIndex(int index){
        if(index<0 || index>size){
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    /**
     * 返回数组中元素的个数
     * @return      元素的个�?
     */
    public int getSize(){
        return size;
    }

    @Override
    public String toString() {
        String informationDetail = "";
        for(E element : elements){
            if(element != null){
                informationDetail += element + "\n";
            }
        }
        return  informationDetail;
    }
}

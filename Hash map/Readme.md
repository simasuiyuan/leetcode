# Hash Table Overview

## When to use 
### 当我们遇到了要快速判断一个元素是否出现集合里的时候，就要考虑哈希法. when want to find out if a element in a domain (set) **fast/ quick**
### Hash Table sacrifices the space to achieve speed

## Implementation

### 1. Hash Table
* index -> element
![哈希表1](https://img-blog.csdnimg.cn/20210104234805168.png)

* The size of hash table is pre-determined

### 2. Hash Function
* new_element value -> Hash table -> index? : (if there is a new element to be stored in a hash table, whats its index to be stored at?)
* **index = Hash_Func(HashCode(new_ele_Val))** : The hash Code will encode the element value into a integer value as index that can be map to hash table
    #### problems handling
    1. What if Hash_Code(new_ele_Val) > table_size - 1 (the last index in hash table) ?
       * Solution: **Hash_Func = HashCode(new_ele_Val) % tableSize**
    2. If we % over TableSize -> there is chance that Hash_Func(HashCode(new_ele_Val1)) == Hash_Func(HashCode(new_ele_Val2))?
       #### This is known as **Hash Collision**!
        ![哈希表3](https://img-blog.csdnimg.cn/2021010423494884.png)
       #### **Solution 1**: 
       * each element stored in Hash table using **Linked List**: eg. @index new_ele_Val1 -> new_ele_Val2
        ![哈希表4](https://img-blog.csdnimg.cn/20210104235015226.png)

       #### **Solution 2**: 
       * **linear search**: if index of new element looks for is occupied -> look for next index
       * Note!: this solution has to ensure that the table size is larger than data size!
        ![哈希表5](https://img-blog.csdnimg.cn/20210104235109950.png)

### 3. common implementation of hash table
* Array
* set
* map (dictionary)
* 
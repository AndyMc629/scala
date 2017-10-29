val text = sc.textFile("/home/andrew/dev/GitHub/scala/sparkscripts/data/reut2-000.sgm")
val counts = text.flatMap(line => line.split(" ")).map(word => (word,1)).reduceByKey(_+_)
counts.collect
System.exit(0)

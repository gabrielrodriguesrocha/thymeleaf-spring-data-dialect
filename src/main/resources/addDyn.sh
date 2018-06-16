#!/bin/bash

IFS=$'\n'
for i in thymeleaf-spring-data-dialect/*;
	do
	grep -a 'href' $i | sed 's/href/onclick/g' | sed 's/^/dynamic\./' >> $i
done	

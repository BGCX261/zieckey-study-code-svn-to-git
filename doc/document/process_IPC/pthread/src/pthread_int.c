/********************************************************************************************
**	Name:pthread_int.c
**	Used to study the multithread programming in Linux OS
**	Pass a parameter to the thread.
**	Author:zeickey
**	Date:2006/9/16		
**	Copyright (c) 2006,All Rights Reserved!
*********************************************************************************************/

#include <stdio.h>
#include <pthread.h>
#include <unistd.h>

void *create(void *arg)
{
	int *num;
	num=(int *)arg;
	printf("create parameter is %d \n",*num);
	return (void *)0;
}
int main(int argc ,char *argv[])
{
	pthread_t tidp;
	int error;
	
	int test=4;
	int *attr=&test;
	
	error=pthread_create(&tidp,NULL,create,(void *)attr);

	if(error)
   	 {
		printf("pthread_create is created is not created ... \n");
		return -1;
   	 }
	sleep(1);
	printf("pthread_create is created ...\n");
	return 0;		
}


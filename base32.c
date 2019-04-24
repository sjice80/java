/*
 * main.c
 *
 *  Created on: 2017. 9. 10.
 *      Author: ±è¼öÁ¤
 */
#include <stdio.h>
#include <string.h>

int main(int argc, char *argv[]) {
	// your code goes here
	static const char MimeBase64[] = {
		'A','B','C','D','E','F','G','H',
		'I','J','K','L','M','N','O','P',
		'Q','R','S','T','U','V','W','X',
		'Y','Z','a','b','c','d','e','f',
		'g','h','i','j','k','l','m','n',
		'o','p','q','r','s','t','u','v',
		'w','x','y','z','0','1','2','3',
		'4','5','6','7','8','9','+','/'
	};

	char str[20] = {0x00, };
	char b[50] = {0x00, };
	char ch;
	int cnt = 0, idx = 0;
	memcpy(str, argv[1], strlen(argv[1]));

	printf("input: %s, %d\n", str, '1'-'0');
	for(int i=0; i<strlen(argv[1]); i++)
	{
		ch = str[i];
		for(int j=7; j>=0; j--)
		{
			if((ch >> j) & 0x01)
			{
				printf("1");
			}
			else
			{
				printf("0");
			}
			b[idx] = (b[idx] << 1) | ((ch >> j) & 0x01);
			cnt++;
			if(cnt%5 == 0)
			{
				printf("\t(%d, %C)\n", b[idx], MimeBase64[(int)b[idx]]);
				idx++;
			}
		}

	}
	return 0;
}


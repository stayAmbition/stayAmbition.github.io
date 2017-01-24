[codectption](http://codeception.com/) 
------

[codeception for laravel](http://codeception.com/for/laravel)
------  

# install 
    
    后补

# generate

    php vendor/bin/codecept generate:cept api Login  系统会在tests/api下创建一个LoginCept.php文件 
    php vendor/bin/codecept generate:test unit User  系统会在tests/unit下创建一个UserTest.php文件 
    php vendor/bin/codecept generate:cept functional Route/RoutesInvalid 系统创建tests/functional/Route/RoutesInvalidCept.php 
  
    注意：windows不能使用  php vendor/bin/codecept 命令 
    使用：php vendor/codeception/codeception/codecept 
  
# run 

    php vendor/bin/codecept run 运行tests下全部的测试文件 
    php vendor/bin/codecept run unit 运行tests/unit下全部的测试文件 
    php vendor/bin/codecept run api Tag/TagGetQrcodeCept -d  运行tests/api/Tag/TagGetQrcodeCept.php 
    
    注意：建议多使用 -d 来查看
    

for(i = 'a'; i < 'd'; i++)
{
    println i
}
println ""
for(i in 'a'..'z')
{
    if(i == 'z'){
        print "$i"
        break;
    }
    print "$i,"
}

println ""
lst = ['hello']
lst << 'there'
println lst

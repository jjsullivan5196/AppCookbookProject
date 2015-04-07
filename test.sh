function assert () {
  if [[ "$1" = "$2" ]]; then
    echo success
    exit 0
  else
    echo error: $1 does not equal $2
    exit 1
  fi
}

actual=`java -cp /home/jsullivan/Documents/cst395/test/target/test-1.0-SNAPSHOT.jar com.example.test.App mwall@csumb.edu 2`
expected="[lchilders@csumb.edu, almendoza@csumb.edu, mwall@csumb.edu]"

assert "$actual" "$expected"


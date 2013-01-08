(ns jruby-ast-clj.core
  (:import [org.jruby     Ruby RubyInstanceConfig]
           [java.io       ByteArrayInputStream]
           [org.jruby.ast DefnNode]))

(defn root-node
  "Returns the RootNode of the AST representing the given Ruby program"
  [ruby-program]
  (let [prog (ByteArrayInputStream. (.getBytes ruby-program))
        config (RubyInstanceConfig.)
        runtime (Ruby/newInstance config)]
    (.parseInline runtime prog "dummy.rb" nil)))

(defn -main
  [file]
  (let [root (root-node (slurp file))]
    root))

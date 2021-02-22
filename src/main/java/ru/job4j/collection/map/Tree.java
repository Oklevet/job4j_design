package ru.job4j.collection.map;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Optional;
import java.util.Queue;
import java.util.function.Predicate;

class Tree<E> implements SimpleTree<E> {
    private final Node<E> root;

    Tree(final E root) {
        this.root = new Node<>(root);
    }

    @Override
    public boolean add(E parent, E child) {
        Optional<Node<E>> isParent = findBy(parent);
        if (isParent.isPresent()) {
            if (findBy(child).isEmpty()) {
                isParent.get().getChildren().add(new Node<>(child));
                return true;
            }
        }
        return false;
    }

    private Optional<Node<E>> findByPredicate(Predicate<Node<E>> condition) {
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(this.root);
        while (!queue.isEmpty()) {
            Node<E> elem = queue.poll();
            if (condition.test(elem)) {
                return Optional.of(elem);
            }
            queue.addAll(elem.children);
        }
        return Optional.empty();
    }

    public boolean isBinary() {
        Predicate<Node<E>> predicate = x -> x.getChildren().size() > 2;
        return findByPredicate(predicate).isEmpty();
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
    Predicate<Node<E>> predicate = x -> x.value.equals(value);
        return findByPredicate(predicate);
    }

    @Override
    public String toString() {
        return "Tree{"
                + "parent =" + root.value
                + ", child ='" + root.children + '\''
                + '}';
    }
}

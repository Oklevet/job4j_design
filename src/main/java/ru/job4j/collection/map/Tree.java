package ru.job4j.collection.map;

import java.util.LinkedList;
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

    public boolean isBinary() {
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(this.root);
        while (!queue.isEmpty()) {
            if (queue.poll().getChildren().size() > 2) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tree{"
                + "parent =" + root.value
                + ", child ='" + root.children + '\''
                + '}';
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.value.equals(value)) {
                rsl = Optional.of(el);
                break;
            }
            data.addAll(el.children);
        }
        return rsl;
    }
}
